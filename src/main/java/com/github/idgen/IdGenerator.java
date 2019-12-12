package com.github.idgen;

import java.time.LocalDateTime;
import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {

    private static final long INIT_TIME = 1514736000L;

    //time sec(68y)
    private static final long TIMESTAMP_BIT = 31;
    //work id(4k)
    private static final long WORKER_NODE_BIT = 12;
    //seq(1m)
    private static final long SEQUENCE_BIT = 20;

    private static final long MAX_TIMESTAMP = ~(-1L << TIMESTAMP_BIT);
    private static final long MAX_WORKER_NODE = ~(-1L << WORKER_NODE_BIT);
    private static final long MAX_SEQUENCE = ~(-1L << SEQUENCE_BIT);

    private static final long WORKER_NODE_LEFT = SEQUENCE_BIT;
    private static final long TIMESTAMP_LEFT = WORKER_NODE_BIT + WORKER_NODE_LEFT;

    private long workerId;

    private AtomicLong sequence = new AtomicLong(0L);

    private volatile long lastTimestamp = INIT_TIME;

    public IdGenerator(long workerId) {
        if (workerId > MAX_WORKER_NODE || workerId < 0) {
            throw new IllegalArgumentException("Invalid argument: workId");
        }
        this.workerId = workerId;
    }

    public long generateId() {
        long currTime = System.currentTimeMillis() / 1000;
        if (currTime != lastTimestamp) {
            sequence = new AtomicLong(0L);

        }
    }

}
