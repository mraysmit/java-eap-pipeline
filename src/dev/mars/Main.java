package dev.mars;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Trade trade = new Trade("ORD123","ABC", 200.0);

        TradeProcessingPipeline pipeline = new TradeProcessingPipeline();
        pipeline.addStage(new ValidationStage());
        pipeline.addStage(new ConfirmationStage());
        pipeline.addStage(new BookingStage());

        pipeline.process(trade);


    }



}