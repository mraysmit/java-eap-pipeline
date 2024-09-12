package test.mars;

import dev.mars.tradeprocess.Trade;
import dev.mars.tradeprocess.ConfirmationStage;
import dev.mars.tradeprocess.TradeStatus;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ConfirmationStageTest {

    @Test
    public void testConfirmationProcessed() {
        Trade trade = new Trade("ORD123", "ABC",100.0);
        trade.setStatus(TradeStatus.VALID);
        ConfirmationStage stage = new ConfirmationStage();
        stage.invoke(trade);
        assertEquals(TradeStatus.CONFIRMED, trade.getStatus());
    }

    @Test
    public void testConfirmationFailed() {
        Trade trade = new Trade("ORD123","ABC", 100.0);
        trade.setStatus(TradeStatus.INVALID);
        ConfirmationStage stage = new ConfirmationStage();
        stage.invoke(trade);
        assertEquals(TradeStatus.NOT_CONFIRMED, trade.getStatus());
    }
}
