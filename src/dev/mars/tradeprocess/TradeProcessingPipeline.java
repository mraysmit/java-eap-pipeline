package dev.mars.tradeprocess;

import dev.mars.pipeline.Operation;
import dev.mars.pipeline.ProcessingPipeline;

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
            System.out.println("------- Processing stage: " + stage.getClass().getSimpleName());
            stage.invoke(trade);

            if (onError(trade)) {
                System.out.println("Trade processing incomplete. Exiting pipeline at Stage: " + stage.getClass().getSimpleName());
                break;
            }
        }
        return trade;
    }

    @Override
    public boolean onError(Trade t) {
        return ((t.getStatus() == TradeStatus.INVALID) ||
                (t.getStatus() == TradeStatus.NOT_CONFIRMED) ||
                (t.getStatus() == TradeStatus.NOT_BOOKED));
    }

    @Override
    public boolean onComplete(Trade trade) {
        return false;
    }
}