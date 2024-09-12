package dev.mars.tradeprocess;

import dev.mars.pipeline.Operation;

public class BookingStage implements Operation<Trade> {

    public Trade invoke(Trade trade) {

        if (trade.getStatus() == TradeStatus.CONFIRMED || trade.getStatus() == TradeStatus.BOOKED)  {
            trade.setStatus(TradeStatus.BOOKED);
            System.out.println("Trade Booked " + trade);
        } else {
            trade.setStatus(TradeStatus.NOT_BOOKED);
            System.out.println("Trade Booking failed " + trade);
        }
        return trade;
    }


}

