package dev.mars;

public class Trade {
    private final String tradeId;
    private final String counterpartyId;
    private final double amount;
    private TradeStatus status;


    public Trade(String tradeId, String counterpartyId, double amount) {
        this(tradeId, counterpartyId, amount, TradeStatus.NEW);
    }

    public Trade(String tradeId, String counterpartyId, double amount, TradeStatus status) {
        this.tradeId = tradeId;
        this.counterpartyId = counterpartyId;
        this.amount = amount;
        this.status = status;
    }

    public String getTradeId() {
        return tradeId;
    }

    public String getCounterpartyId() {
        return counterpartyId;
    }

    public double getAmount() {
        return amount;
    }

    public TradeStatus getStatus() {
        return status;
    }

    public void setStatus(TradeStatus status) {
        this.status =   status;
    }

    public String toString() {
        return String.format("Trade Id: %s, Counterparty Id %s, amount: %s, status: %s", tradeId, counterpartyId, amount, status);
    }
}