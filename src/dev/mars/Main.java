package dev.mars;

import dev.mars.tradeprocess.*;

public class Main {
    public static void main(String[] args) {

        Trade trade = new Trade("ORD123","ABC", 200.0);

        // Create a new TradeProcessingPipeline and add stages
        TradeProcessingPipeline pipeline = new TradeProcessingPipeline();
        pipeline.addStage(new ValidationStage());
        pipeline.addStage(new ConfirmationStage());
        pipeline.addStage(new BookingStage());

        // Initiate the processing pipeline with the trade
        pipeline.process(trade);



    }



}