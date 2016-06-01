package io.pivotal.bds.gemfire.fraud.common.data;

import java.util.Arrays;

import com.datastax.driver.mapping.annotations.Column;
import com.datastax.driver.mapping.annotations.PartitionKey;
import com.datastax.driver.mapping.annotations.Table;

import io.pivotal.bds.gemfire.fraud.common.util.XCodec;
import io.pivotal.bds.gemfire.fraud.common.util.YCodec;

@Table(name = "card_classifier", keyspace = "gemfire")
public class CardClassifierData {

    @PartitionKey
    @Column(name = "card_id")
    private String cardId;

    @Column(name = "account_id")
    private String accountId;

    @Column(name = "x", codec = XCodec.class)
    private double[][] x;

    @Column(name = "y", codec = YCodec.class)
    private int[] y;

    public CardClassifierData() {
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double[][] getX() {
        return x;
    }

    public void setX(double[][] x) {
        this.x = x;
    }

    public int[] getY() {
        return y;
    }

    public void setY(int[] y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "CardClassifierData [cardId=" + cardId + ", accountId=" + accountId + ", x=" + Arrays.toString(x) + ", y="
                + Arrays.toString(y) + "]";
    }

}
