package io.pivotal.bds.gemfire.mongodb.data;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.Date;

import com.gemstone.gemfire.DataSerializable;
import com.gemstone.gemfire.DataSerializer;

@SuppressWarnings("serial")
public class Account implements DataSerializable {

    private String id;
    private String name;
    private double amount;
    private Date createdOn;

    public Account() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    @Override
    public void fromData(DataInput in) throws IOException, ClassNotFoundException {
        id = DataSerializer.readString(in);
        name = DataSerializer.readString(in);
        amount = in.readDouble();
        createdOn = DataSerializer.readDate(in);
    }

    @Override
    public void toData(DataOutput out) throws IOException {
        DataSerializer.writeString(id, out);
        DataSerializer.writeString(name, out);
        out.writeDouble(amount);
        DataSerializer.writeDate(createdOn, out);
    }

    @Override
    public String toString() {
        return "Account [id=" + id + ", name=" + name + ", amount=" + amount + ", createdOn=" + createdOn + "]";
    }

}
