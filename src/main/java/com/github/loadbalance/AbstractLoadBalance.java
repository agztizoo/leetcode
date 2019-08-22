package com.github.loadbalance;

import java.util.List;

public abstract class AbstractLoadBalance implements LoadBalance {

    @Override
    public Object select(List<Node> nodes) {
        if (nodes == null || nodes.size() == 0) {
            return null;
        }
        if (nodes.size() == 1) {
            return nodes.get(0);
        }
        return doSelect(nodes).getTarget();
    }

    protected abstract Node doSelect(List<Node> nodes);

}
