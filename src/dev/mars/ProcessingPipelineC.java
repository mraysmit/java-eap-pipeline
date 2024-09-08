package dev.mars;

import java.util.ArrayList;
import java.util.List;

public class ProcessingPipelineC<T extends Trade> implements ProcessingPipeline<T> {

    private final List<Operation<T>> pipeline = new ArrayList<>();

    public ProcessingPipelineC<T> addStage(Operation<T> stage) {
        pipeline.add(stage);
        return this;
    }

    @Override
    public T process(T trade) {
        for (Operation<T> stage : pipeline) {
            stage.invoke(trade);

            if ("INVALID".equals(trade.getStatus()) ||
                "REJECTED".equals(trade.getStatus()) ||
                "NOT_BOOKED".equals(trade.getStatus())) {
                break;
            }
        }
        return trade;
    }
}