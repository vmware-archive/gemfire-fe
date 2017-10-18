package io.pivotal.bds.gemfire.r.common;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Consumer;

import org.apache.commons.collections4.queue.CircularFifoQueue;

import org.apache.geode.DataSerializable;
import org.apache.geode.DataSerializer;

@SuppressWarnings("serial")
public class Window<T> extends CircularFifoQueue<T>implements DataSerializable {

    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = readWriteLock.readLock();
    private final Lock writeLock = readWriteLock.writeLock();

    public Window(int size) {
        super(size);
    }

    @Override
    public int size() {
        readLock.lock();
        try {
            return super.size();
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public boolean isEmpty() {
        readLock.lock();
        try {
            return super.isEmpty();
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public boolean isFull() {
        readLock.lock();
        try {
            return super.isFull();
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public boolean isAtFullCapacity() {
        readLock.lock();
        try {
            return super.isAtFullCapacity();
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public int maxSize() {
        readLock.lock();
        try {
            return super.maxSize();
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public void clear() {
        writeLock.lock();
        try {
            super.clear();
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public boolean add(T element) {
        writeLock.lock();
        try {
            return super.add(element);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public T get(int index) {
        readLock.lock();
        try {
            return super.get(index);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public boolean offer(T element) {
        writeLock.lock();
        try {
            return super.offer(element);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public T poll() {
        readLock.lock();
        try {
            return super.poll();
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public T element() {
        readLock.lock();
        try {
            return super.element();
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public T peek() {
        readLock.lock();
        try {
            return super.peek();
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public T remove() {
        writeLock.lock();
        try {
            return super.remove();
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public Iterator<T> iterator() {
        throw new UnsupportedOperationException("Method 'iterator' not supported");
    }

    @Override
    public boolean contains(Object o) {
        readLock.lock();
        try {
            return super.contains(o);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public Object[] toArray() {
        readLock.lock();
        try {
            return super.toArray();
        } finally {
            readLock.unlock();
        }
    }

    @SuppressWarnings("hiding")
    @Override
    public <T> T[] toArray(T[] a) {
        readLock.lock();
        try {
            return super.toArray(a);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public boolean remove(Object o) {
        writeLock.lock();
        try {
            return super.remove(o);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        readLock.lock();
        try {
            return super.containsAll(c);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        writeLock.lock();
        try {
            return super.addAll(c);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        writeLock.lock();
        try {
            return super.removeAll(c);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        writeLock.lock();
        try {
            return super.retainAll(c);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public String toString() {
        readLock.lock();
        try {
            return super.toString();
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        readLock.lock();
        try {
            super.forEach(action);
        } finally {
            readLock.unlock();
        }
    }

    public List<T> asList() {
        readLock.lock();
        try {
            List<T> list = new ArrayList<>();
            Iterator<T> iter = super.iterator();

            while (iter.hasNext()) {
                list.add(iter.next());
            }

            return list;
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public void fromData(DataInput in) throws IOException, ClassNotFoundException {
        writeLock.lock();
        try {
            super.clear();
            int c = in.readInt();
            for (int i = 0; i < c; ++i) {
                T t = DataSerializer.readObject(in);
                super.add(t);
            }
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public void toData(DataOutput out) throws IOException {
        readLock.lock();
        try {
            int c = super.size();
            out.writeInt(c);
            Iterator<T> iter = super.iterator();
            while (iter.hasNext()) {
                T t = iter.next();
                DataSerializer.writeObject(t, out);
            }
        } finally {
            readLock.unlock();
        }
    }
}
