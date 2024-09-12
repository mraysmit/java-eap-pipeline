package dev.mars.pipeline;

public interface ProcessingPipeline<T> {
    T process(T t);
    boolean onError(T t);
    boolean onComplete(T t);
}
