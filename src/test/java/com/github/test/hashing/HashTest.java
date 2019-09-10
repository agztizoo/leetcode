package com.github.test.hashing;

import com.github.hashing.ConsistentHashing;
import com.github.hashing.impl.MurHashMethod;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.atomic.AtomicInteger;

public class HashTest {

    private static final String[] nodes = {
            "127.0.0.1:3303",
            "127.0.0.1:3304",
            "127.0.0.1:3305",
            "127.0.0.1:3306",
            "127.0.0.1:3307",
            "127.0.0.1:3308"
    };

    public static void main(String[] args) throws IOException {

        ConsistentHashing consistent = new ConsistentHashing(new MurHashMethod(), nodes);

        Map<String, String> cache = new HashMap<>();

        List<String> data = loadTestData();

        init(consistent, cache, data);

        afterAdd(consistent, cache, data);

        afterDelete(consistent, cache, data);
    }

    /**
     * 初始分配，输出分配结果
     *
     * @param consistent
     * @param cache
     * @param data
     */
    private static void init(ConsistentHashing consistent, Map<String, String> cache, List<String> data) {
        Map<String, AtomicInteger> counter = new HashMap<>();
        for (String node : nodes) {
            counter.put(node, new AtomicInteger(0));
        }

        data.forEach((line) -> {
            String node = consistent.getNode(line);
            cache.put(line, node);
            counter.get(node).incrementAndGet();
        });

        for (Entry<String, AtomicInteger> entry : counter.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue().get());
        }
    }

    private static void afterDelete(ConsistentHashing consistent, Map<String, String> cache, List<String> data) {
        consistent.removeNode("127.0.0.1:3314");
        consistent.removeNode("127.0.0.1:3305");
        AtomicInteger count = new AtomicInteger(0);
        AtomicInteger hit = new AtomicInteger(0);

        data.forEach((line) -> {
            String node = consistent.getNode(line);
            String cacheNode = cache.get(line);
            count.incrementAndGet();
            if (node.equals(cacheNode)) {
                hit.incrementAndGet();
            }
        });
        System.out.println(hit.get()/count.doubleValue());
    }

    private static void afterAdd(ConsistentHashing consistent, Map<String, String> cache, List<String> data) {
        consistent.addNode("127.0.0.1:3314");
        AtomicInteger count = new AtomicInteger(0);
        AtomicInteger hit = new AtomicInteger(0);

        data.forEach((line) -> {
            String node = consistent.getNode(line);
            String cacheNode = cache.get(line);
            count.incrementAndGet();
            if (node.equals(cacheNode)) {
                hit.incrementAndGet();
            }
        });
        System.out.println(hit.get()/count.doubleValue());
    }

    private static List<String> loadTestData() throws IOException {
        List<String> data = new ArrayList<>(30000);
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(HashTest.class.getClassLoader().getResourceAsStream("13300545102.txt")))) {
            String line = null;
            while ((line = reader.readLine()) != null) {
                data.add(line);
            }
        }
        return data;
    }

}
