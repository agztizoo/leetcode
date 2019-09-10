package com.github.loadbalance;

import java.util.List;

public interface LoadBalance {

    String select(List<Node> nodes);

}
