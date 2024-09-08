package dev.mars;

public class BookingStage implements Operation<Trade> {

    public Trade invoke(Trade trade) {

        if ("CONFIRMED".equals(trade.getStatus()) || "BOOKED".equals(trade.getStatus()))  {
            trade.setStatus("BOOKED");
            System.out.println("Trade Booked " + trade);
        } else {
            trade.setStatus("NOT_BOOKED");
            System.out.println("Trade Booking failed " + trade);
        }
        return trade;
    }


}

