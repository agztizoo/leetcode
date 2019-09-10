package com.github.test.loadbalance;

import com.github.loadbalance.LoadBalance;
import com.github.loadbalance.Node;
import com.github.loadbalance.impl.WeightedRoundRobinLoadBalance;
import com.google.common.collect.Lists;

import java.util.List;

public class LoadBalanceTest {

    public static void main(String[] args) {
        LoadBalance balance = new WeightedRoundRobinLoadBalance();
        List<Node> nodes = Lists.newArrayList(new Node(10, "A"),
                new Node(5, "B"),
                new Node(15, "C"),
                new Node(30, "D"),
                new Node(40, "E"));
        for (int i = 0; i < 20; i++) {
            System.out.println(balance.select(nodes));
        }
    }

}
