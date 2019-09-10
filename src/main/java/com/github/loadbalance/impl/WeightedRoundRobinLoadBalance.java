package com.github.loadbalance.impl;

import com.github.loadbalance.AbstractLoadBalance;
import com.github.loadbalance.Node;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class WeightedRoundRobinLoadBalance extends AbstractLoadBalance {

    private ConcurrentHashMap<String, WeightedItem> weightedItemMap = new ConcurrentHashMap<>();

    @Override
    protected Node doSelect(List<Node> nodes) {

        List<WeightedItem> items = nodes.stream().map(node -> weightedItemMap.computeIfAbsent(node.getTarget(),
                    n -> new WeightedItem(node.getPercent(), node))
        ).collect(Collectors.toList());

        return next(items);
    }

    private Node next(List<WeightedItem> items) {
        WeightedItem selected = null;
        int total = 0;
        int maxWeight = 0;
        for (WeightedItem item : items) {
            int current = item.increaseCurrent();
            if (current > maxWeight) {
                maxWeight = current;
                selected = item;
            }
            total += item.getWeight();
        }
        if (selected != null) {
            selected.select(total);
            return selected.getNode();
        }
        return items.get(0).getNode();
    }

    @Getter
    @Setter
    @RequiredArgsConstructor
    private static class WeightedItem {
        @NonNull
        private int weight;
        private AtomicInteger currentWeight = new AtomicInteger(0);
        @NonNull
        private Node node;

        public int increaseCurrent() {
            return currentWeight.addAndGet(weight);
        }
        public void select(int total) {
            currentWeight.addAndGet(-1 * total);
        }
    }

}
