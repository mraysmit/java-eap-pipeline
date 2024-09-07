package test.mars;


import dev.mars.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class OrderTest {

    @Test
    public void testTradeConstructor() {
        Trade trade = new Trade("123", "ABC", 100.0);
        assertEquals("123", trade.getTradeId());
        assertEquals(100.0, trade.getAmount());
        assertEquals("NEW", trade.getStatus());
    }

    @Test
    public void testTradeFullConstructor() {
        Trade order = new Trade("123", "XYZ", 100.0, "COMPLETED");
        assertEquals("123", order.getTradeId());
        assertEquals("XYZ", order.getCounterpartyId());
        assertEquals(100.0, order.getAmount());
        assertEquals("COMPLETED", order.getStatus());
    }

    @Test
    public void testSettersAndGetters() {
        Trade order = new Trade();
        order.setTradeId("123");
        order.setAmount(100.0);
        order.setStatus("NEW");

        assertEquals("123", order.getTradeId());
        assertEquals(100.0, order.getAmount());
        assertEquals("NEW", order.getStatus());
    }

    @Test
    public void testToString() {
        Trade order = new Trade("123", "ABC",100.0, "NEW");
        String expected = "Trade: 123, amount: 100.0, status: NEW";
        assertEquals(expected, order.toString());
    }
}

