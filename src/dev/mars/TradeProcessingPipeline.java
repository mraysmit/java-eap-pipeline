package dev.mars;

import java.util.ArrayList;
import java.util.List;

public class TradeProcessingPipeline implements ProcessingPipeline<Trade> {

    private final List<Operation<Trade>> pipeline = new ArrayList<>();

    public TradeProcessingPipeline addStage(Operation<Trade> stage) {
        pipeline.add(stage);
        return this;
    }

    @Override
    public Trade process(Trade trade) {
        for (Operation<Trade> stage : pipeline) {
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