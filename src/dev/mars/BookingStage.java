package dev.mars;

public class BookingStage implements TradeProcessingFlow {

    public Trade process(Trade trade) {

        if ("ENRICHED".equals(trade.getStatus())) {
            trade.setStatus("BOOKED");
            System.out.println("Trade Booked " + trade);
        } else {
            trade.setStatus("NOT_BOOKED");
            System.out.println("Trade Booking failed " + trade);
        }
        return trade;
    }
}

