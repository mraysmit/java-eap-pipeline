package test.mars;

import dev.mars.Trade;
import dev.mars.ConfirmationStage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConfirmationStageTest {

    @Test
    public void testConfirmationProcessed() {
        Trade trade = new Trade("ORD123", "ABC",100.0);
        trade.setStatus("VALID");
        ConfirmationStage stage = new ConfirmationStage();
        stage.process(trade);
        assertEquals("CONFIRMED", trade.getStatus());
    }

    @Test
    public void testConfirmationFailed() {
        Trade trade = new Trade("ORD123","ABC", 100.0);
        trade.setStatus("INVALID");
        ConfirmationStage stage = new ConfirmationStage();
        stage.process(trade);
        assertEquals("FAILED", trade.getStatus());
    }
}
