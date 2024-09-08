package dev.mars;

public interface Operation<T> {
    T invoke(T t);
}

