package com.github.loadbalance.impl;

import com.github.loadbalance.AbstractLoadBalance;
import com.github.loadbalance.Node;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class RoundRobinLoadBalance extends AbstractLoadBalance {

    private AtomicInteger index = new AtomicInteger(0);

    @Override
    protected Node doSelect(List<Node> nodes) {
        return nodes.get(getIndex() % nodes.size());
    }

    private int getIndex() {
        return (Integer.MAX_VALUE & index.incrementAndGet());
    }

}
