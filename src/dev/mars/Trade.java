package dev.mars;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Trade {
    private String tradeId;
    private String counterpartyId;
    private double amount;
    private String status;

    public Trade(String orderId, String counterpartyId, double amount) {
        tradeId = orderId;
        this.counterpartyId = counterpartyId;
        this.amount = amount;
        this.status = "NEW";
    }

    public String toString() {
        return String.format ("Trade Id: %s, Counterparty Id %s, amount: %s, status: %s", tradeId, counterpartyId, amount, status);
    }
}
