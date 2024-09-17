package test.mars;

import dev.mars.tradeprocess.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TradeProcessingPipelineTest {

    @Test
    public void testPipelineProcessing() {
        Trade trade = new Trade("TRADE123", "ABC", 100.0);

        TradeProcessingPipeline pipeline = new TradeProcessingPipeline();
        pipeline.addStage(new ValidationStage());
        pipeline.addStage(new ConfirmationStage());
        pipeline.addStage(new BookingStage());

        pipeline.process(trade);

        assertEquals(TradeStatus.BOOKED, trade.getStatus());
    }

    @Test
    public void testPipelineInvalidTrade() {
        Trade trade = new Trade("TRADE456", "XYZ",2000.0);

        TradeProcessingPipeline pipeline = new TradeProcessingPipeline();
        pipeline.addStage(new ValidationStage());
        pipeline.addStage(new ConfirmationStage());
        pipeline.addStage(new BookingStage());

        //
        pipeline.process(trade);

        assertEquals(TradeStatus.INVALID, trade.getStatus());
    }
}


