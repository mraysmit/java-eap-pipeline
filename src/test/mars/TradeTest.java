package test.mars;


import dev.mars.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TradeTest {

    @Test
    public void testTradeConstructor() {
        Trade trade = new Trade("123", "ABC", 100.0);
        assertEquals("123", trade.getTradeId());
        assertEquals(100.0, trade.getAmount());
        assertEquals(TradeStatus.NEW, trade.getStatus());
    }

    @Test
    public void testTradeFullConstructor() {
        Trade trade = new Trade("123", "XYZ", 100.0, TradeStatus.CONFIRMED);
        assertEquals("123", trade.getTradeId());
        assertEquals("XYZ", trade.getCounterpartyId());
        assertEquals(100.0, trade.getAmount());
        assertEquals(TradeStatus.CONFIRMED, trade.getStatus());
    }

    @Test
    public void testSettersAndGetters() {
        Trade trade = new Trade("123", "ABC", 100.0, TradeStatus.NEW);

        assertEquals("123", trade.getTradeId());
        assertEquals(100.0, trade.getAmount());
        assertEquals(TradeStatus.NEW, trade.getStatus());
    }

    @Test
    public void testToString() {
        Trade trade = new Trade("123", "ABC",100.0, TradeStatus.NEW);
        String expected = "Trade Id: 123, Counterparty Id ABC, amount: 100.0, status: NEW";
        assertEquals(expected, trade.toString());
    }
}

