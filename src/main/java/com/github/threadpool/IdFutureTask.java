package com.github.threadpool;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

public class IdFutureTask<V> extends FutureTask<V> implements Identifiable {

    private String id;

    public IdFutureTask(Callable<V> callable) {
        super(callable);
        if (callable instanceof Identifiable) {
            this.id = ((Identifiable) callable).getId();
        }
    }

    public IdFutureTask(Runnable runnable, V result) {
        super(runnable, result);
        if (runnable instanceof Identifiable) {
            this.id = ((Identifiable) runnable).getId();
        }
    }

    @Override
    public String getId() {
        return id;
    }
}
