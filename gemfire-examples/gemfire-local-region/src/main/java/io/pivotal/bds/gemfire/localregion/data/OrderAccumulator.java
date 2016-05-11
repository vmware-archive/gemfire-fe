package io.pivotal.bds.gemfire.localregion.data;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import io.pivotal.bds.gemfire.data.ecom.Order;

public class OrderAccumulator {

    private transient final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private transient final Lock readLock = readWriteLock.readLock();
    private transient final Lock writeLock = readWriteLock.writeLock();

    private OrderTotals totals;

    public OrderAccumulator() {
    }

    public OrderAccumulator(OrderTotals totals) {
        this.totals = totals;
    }

    public OrderTotals getTotals() {
        readLock.lock();
        try {
            return totals;
        } finally {
            readLock.unlock();
        }
    }

    public void add(Order order) {
        writeLock.lock();
        try {
            int count = totals.getCount() + 1;
            double total = totals.getTotal() + order.getTotal();
            totals = new OrderTotals(count, total);
        } finally {
            writeLock.unlock();
        }
    }

    public void remove(Order order) {
        writeLock.lock();
        try {
            int count = totals.getCount() - 1;
            double total = totals.getTotal() - order.getTotal();
            
            count = count < 0 ? 0 : count;
            total = total < 0.0 ? 0.0 : total;
            
            totals = new OrderTotals(count, total);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public String toString() {
        return "OrderAccumulator [totals=" + totals + "]";
    }

}
