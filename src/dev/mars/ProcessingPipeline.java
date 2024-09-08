package dev.mars;

public interface ProcessingPipeline<T> {
    T process(T t);
}
