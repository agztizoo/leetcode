package com.github.threadpool;

import com.github.hashing.HashMethod;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@NoArgsConstructor
public class BindableThreadPoolExecutor extends AbstractExecutorService {

    private ExecutorService[] executors;

    private HashMethod hashMethod;

    private int poolSize;

    public BindableThreadPoolExecutor(int poolSize, int queueSize, ThreadFactory threadFactory, HashMethod hashMethod) {
        if (poolSize < 0 || queueSize < 0) {
            throw new IllegalArgumentException();
        }
        if (threadFactory == null) {
            throw new NullPointerException();
        }
        executors = new ExecutorService[poolSize];
        for (int i = 0; i < executors.length; i++) {
            executors[i] = new ThreadPoolExecutor(1, 1, 0L, TimeUnit.MILLISECONDS,
                    new LinkedBlockingQueue<Runnable>(queueSize), threadFactory, new ThreadPoolExecutor.AbortPolicy());
        }
        this.hashMethod = hashMethod;
        this.poolSize = poolSize;
    }

    @Override
    public void shutdown() {
        for (int i = 0; i < executors.length; i++) {
            executors[i].shutdown();
        }
    }

    @Override
    public List<Runnable> shutdownNow() {
        List<Runnable> tasks = new LinkedList<Runnable>();
        for (int i = 0; i < executors.length; i++) {
            tasks.addAll(executors[i].shutdownNow());
        }
        return tasks;
    }

    @Override
    public boolean isShutdown() {
        boolean isShutdown = true;
        for (int i = 0; i < executors.length; i++) {
            isShutdown = isShutdown && executors[i].isShutdown();
        }
        return isShutdown;
    }

    @Override
    public boolean isTerminated() {
        boolean isTerminated = true;
        for (int i = 0; i < executors.length; i++) {
            isTerminated = isTerminated && executors[i].isShutdown();
        }
        return isTerminated;
    }

    @Override
    public boolean awaitTermination(long timeout, TimeUnit unit) throws InterruptedException {
        boolean termination = true;
        for (int i = 0; i < executors.length; i++) {
            termination = termination && executors[i].awaitTermination(timeout, unit);
        }
        return termination;
    }

    @Override
    protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
        return new IdFutureTask<T>(callable);
    }

    @Override
    protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
        return new IdFutureTask<T>(runnable, value);
    }

    @Override
    public void execute(Runnable command) {
        ExecutorService exec = select(command);
        for (;;) {
            try {
                exec.execute(command);
                return;
            } catch (RejectedExecutionException e) {}
        }
    }

    @Override
    public Future<?> submit(Runnable task) {
        ExecutorService exec = select(task);
        for (;;) {
            try {
                return exec.submit(task);
            } catch (RejectedExecutionException e) {}
        }
    }

    @Override
    public <T> Future<T> submit(Callable<T> task) {
        ExecutorService exec = select(task);
        for (;;) {
            try {
                return exec.submit(task);
            } catch (RejectedExecutionException e) {}
        }
    }

    @Override
    public <T> Future<T> submit(Runnable task, T result) {
        ExecutorService exec = select(task);
        for (;;) {
            try {
                return exec.submit(task, result);
            } catch (RejectedExecutionException e) {}
        }
    }

    private ExecutorService select(Object command) {
        int index = (int) (System.currentTimeMillis() % poolSize);
        if (command instanceof Identifiable) {
            Identifiable cmd = (Identifiable) command;
            index = (int) Math.abs((hashMethod.hash(cmd.getId()) % poolSize));
        }
        return executors[index];
    }

}
