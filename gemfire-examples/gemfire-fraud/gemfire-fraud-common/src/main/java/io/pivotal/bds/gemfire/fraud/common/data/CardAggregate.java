package io.pivotal.bds.gemfire.fraud.common.data;

import java.util.List;

public class CardAggregate {

    private Card card;
    private List<TransactionAggregate> transactions;

    public CardAggregate() {
    }

    public Card getCard() {
        return card;
    }

    public void setCard(Card card) {
        this.card = card;
    }

    public List<TransactionAggregate> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<TransactionAggregate> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "CardAggregate [card=" + card + ", transactions=" + transactions + "]";
    }

}
