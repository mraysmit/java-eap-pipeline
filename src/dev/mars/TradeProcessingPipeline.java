package dev.mars;

import java.util.ArrayList;
import java.util.List;

public class TradeProcessingPipeline {

    public List<TradeProcessingFlow> pipeline = new ArrayList<>();

    public TradeProcessingPipeline addStage(TradeProcessingFlow stage) {
        pipeline.add(stage);
        return this;
    }

    public Trade process(Trade trade) {
        for (TradeProcessingFlow stage : pipeline) {
            stage.process(trade);

            if ("INVALID".equals(trade.getStatus()) || "REJECTED".equals(trade.getStatus()) || "NOT_SHIPPED".equals(trade.getStatus())) {
                break;
            }
        }
        return trade;
    }
}

