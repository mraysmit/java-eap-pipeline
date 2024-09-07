package dev.mars;

public class ConfirmationStage implements TradeProcessingFlow {

    @Override
    public Trade process(Trade trade) {
        if ("VALID".equals(trade.getStatus())) {
            trade.setStatus("CONFIRMED");
            System.out.println("Trade confirmed " + trade);
        } else {
            trade.setStatus("FAILED");
            System.out.println("Trade confirm failed " + trade);
        }
        return trade;
    }
}

