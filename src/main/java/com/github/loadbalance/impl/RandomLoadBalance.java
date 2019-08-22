package com.github.loadbalance.impl;

import com.github.loadbalance.AbstractLoadBalance;
import com.github.loadbalance.Node;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomLoadBalance extends AbstractLoadBalance {

    @Override
    protected Node doSelect(List<Node> nodes) {
        return nodes.get(ThreadLocalRandom.current().nextInt(nodes.size()));
    }

}
