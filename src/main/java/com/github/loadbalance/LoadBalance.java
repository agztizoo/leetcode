package com.github.loadbalance;

import java.util.List;

public interface LoadBalance {

    Object select(List<Node> nodes);

}
