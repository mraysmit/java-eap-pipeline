package dev.mars.tradeprocess;

import dev.mars.pipeline.Operation;

public class ValidationStage implements Operation<Trade> {

    public Trade invoke(Trade trade) {
        if (trade.getAmount() > 1000) {
            trade.setStatus(TradeStatus.INVALID);
            System.out.println("Trade Amount Invalid " + trade);
            return trade;
        } else {
            trade.setStatus(TradeStatus.VALID);
            System.out.println("Trade Amount Validated " + trade);
        }

        if (trade.getCounterpartyId().isEmpty()) {
            trade.setStatus(TradeStatus.INVALID);
            System.out.println("Trade Counterparty Invalid " + trade);
            return trade;
        } else {
            trade.setStatus(TradeStatus.VALID);
            System.out.println("Trade Counterparty Validated " + trade);
        }
        return trade;
    }


}
