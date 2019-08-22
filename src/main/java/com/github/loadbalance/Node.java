package com.github.loadbalance;

import lombok.Data;

@Data
public class Node {

    private int percent;

    private Object target;

}
