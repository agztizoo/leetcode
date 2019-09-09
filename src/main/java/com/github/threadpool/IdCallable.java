package com.github.threadpool;

import java.util.concurrent.Callable;

public interface IdCallable<V> extends Callable<V>, Identifiable {

}
