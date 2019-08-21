package com.github.hashing;

import java.util.LinkedList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * @author shaojie
 * @since 2019/8/21
 */
public class ConsistentHashing {

    private static final int VIRTUAL_TOTAL = 1024;

    private SortedMap<Long, String> sortedMap = new TreeMap<>();

    private HashMethod hashMethod;

    private List<String> nodeList = new LinkedList<>();

    private int virtualCount;

    public ConsistentHashing(HashMethod hashMethod, String[] nodes) {
        this.hashMethod = hashMethod;
        virtualCount = VIRTUAL_TOTAL / nodes.length;
        for (String node : nodes) {
            nodeList.add(node);
            for (int i = 0; i < virtualCount; i++) {
                Long hash = hashMethod.hash(node + '@' + i);
                sortedMap.put(hash, node);
            }
        }
    }

    public void addNode(String node) {
        nodeList.add(node);
        for (int i = 0; i < virtualCount; i++) {
            Long hash = hashMethod.hash(node + '@' + i);
            sortedMap.put(hash, node);
        }
    }

    public void removeNode(String node) {
        nodeList.remove(node);
        for (int i = 0; i < virtualCount; i++) {
            Long hash = hashMethod.hash(node + '@' + i);
            sortedMap.remove(hash);
        }
    }

    public String getNode(String key) {
        Long hash = hashMethod.hash(key);
        SortedMap<Long, String> tailMap = sortedMap.tailMap(hash);
        if (!tailMap.isEmpty()) {
            return tailMap.get(tailMap.firstKey());
        }
        return sortedMap.get(sortedMap.firstKey());
    }

}
