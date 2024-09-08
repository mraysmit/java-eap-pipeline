package dev.mars;

public class Trade {
    private String tradeId;
    private String counterpartyId;
    private double amount;
    private String status;


    public Trade(String tradeId, String counterpartyId, double amount) {
        this(tradeId, counterpartyId, amount, "NEW");
    }

    public Trade(String tradeId, String counterpartyId, double amount, String status) {
        this.tradeId = tradeId;
        this.counterpartyId = counterpartyId;
        this.amount = amount;
        this.status = status;
    }

    public String getTradeId() {
        return tradeId;
    }

    public void setTradeId(String tradeId) {
        this.tradeId = tradeId;
    }

    public String getCounterpartyId() {
        return counterpartyId;
    }

    public void setCounterpartyId(String counterpartyId) {
        this.counterpartyId = counterpartyId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("Trade Id: %s, Counterparty Id %s, amount: %s, status: %s", tradeId, counterpartyId, amount, status);
    }
}