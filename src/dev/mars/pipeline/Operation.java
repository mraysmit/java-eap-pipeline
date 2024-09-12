package dev.mars.pipeline;

@FunctionalInterface
public interface Operation<T> {
    T invoke(T t);
}

