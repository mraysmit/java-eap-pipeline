package dev.mars.tradeprocess;

import dev.mars.pipeline.Operation;

public class ConfirmationStage implements Operation<Trade> {

    @Override
    public Trade invoke(Trade trade) {
        if (trade.getStatus() == TradeStatus.BOOKED || trade.getStatus() == TradeStatus.VALID) {
            trade.setStatus(TradeStatus.CONFIRMED);
            System.out.println("Trade confirmed " + trade);
        } else {
            trade.setStatus(TradeStatus.NOT_CONFIRMED);
            System.out.println("Trade confirm failed " + trade);
        }
        return trade;
    }


}

