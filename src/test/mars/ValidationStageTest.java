package test.mars;

import dev.mars.tradeprocess.Trade;
import dev.mars.tradeprocess.TradeStatus;
import dev.mars.tradeprocess.ValidationStage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidationStageTest {

    @Test
    public void testValidTrade() {
        Trade trade = new Trade("ORD123", "ABC", 100.0);
        ValidationStage stage = new ValidationStage();
        stage.invoke(trade);
        assertEquals(TradeStatus.VALID, trade.getStatus());
        assertEquals("ABC", trade.getCounterpartyId());
    }

    @Test
    public void testInvalidOrder() {
        Trade trade = new Trade("ORD123","XYZ", 2000.0);
        ValidationStage stage = new ValidationStage();
        stage.invoke(trade);
        assertEquals(TradeStatus.INVALID, trade.getStatus());
    }
}
