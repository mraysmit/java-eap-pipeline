package dev.mars;

public class ValidationStage implements Operation<Trade> {

    public Trade invoke(Trade trade) {
        if (trade.getAmount() > 1000) {
            trade.setStatus("INVALID");
            System.out.println("Trade Amount Invalid " + trade);
            return trade;
        } else {
            trade.setStatus("VALID");
            System.out.println("Trade Amount Validated " + trade);
        }

        if (trade.getCounterpartyId().isEmpty()) {
            trade.setStatus("INVALID");
            System.out.println("Trade Counterparty Invalid " + trade);
            return trade;
        } else {
            trade.setStatus("VALID");
            System.out.println("Trade Counterparty Validated " + trade);
        }
        return trade;
    }


}
