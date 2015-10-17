package io.pivotal.bds.gemfire.util;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Spliterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class DSLockingArrayList<E> extends DSArrayList<E> {

    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private Lock readLock = lock.readLock();
    private Lock writeLock = lock.writeLock();

    private static final long serialVersionUID = 1L;

    public DSLockingArrayList() {
    }

    public DSLockingArrayList(int initialCapacity) {
        super(initialCapacity);
    }

    public DSLockingArrayList(Collection<? extends E> c) {
        super(c);
    }

    @Override
    public void fromData(DataInput in) throws IOException, ClassNotFoundException {
        writeLock.lock();
        try {
            super.fromData(in);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public void toData(DataOutput out) throws IOException {
        readLock.lock();
        try {
            super.toData(out);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public void trimToSize() {
        writeLock.lock();
        try {
            super.trimToSize();
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public void ensureCapacity(int minCapacity) {
        writeLock.lock();
        try {
            super.ensureCapacity(minCapacity);
        } finally {
            writeLock.unlock();
        }
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
    public boolean contains(Object o) {
        readLock.lock();
        try {
            return super.contains(o);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public int indexOf(Object o) {
        readLock.lock();
        try {
            return super.indexOf(o);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public int lastIndexOf(Object o) {
        readLock.lock();
        try {
            return super.lastIndexOf(o);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public Object clone() {
        readLock.lock();
        try {
            return super.clone();
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
    public E get(int index) {
        readLock.lock();
        try {
            return super.get(index);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public E set(int index, E element) {
        writeLock.lock();
        try {
            return super.set(index, element);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public boolean add(E e) {
        writeLock.lock();
        try {
            return super.add(e);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public void add(int index, E element) {
        writeLock.lock();
        try {
            super.add(index, element);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public E remove(int index) {
        writeLock.lock();
        try {
            return super.remove(index);
        } finally {
            writeLock.unlock();
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
    public void clear() {
        writeLock.lock();
        try {
            super.clear();
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        writeLock.lock();
        try {
            return super.addAll(c);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        writeLock.lock();
        try {
            return super.addAll(index, c);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    protected void removeRange(int fromIndex, int toIndex) {
        writeLock.lock();
        try {
            super.removeRange(fromIndex, toIndex);
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
    public ListIterator<E> listIterator(int index) {
        readLock.lock();
        try {
            @SuppressWarnings("unchecked")
            ArrayList<E> l = (ArrayList<E>) clone();
            return l.listIterator(index);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public ListIterator<E> listIterator() {
        readLock.lock();
        try {
            @SuppressWarnings("unchecked")
            ArrayList<E> l = (ArrayList<E>) clone();
            return l.listIterator();
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public Iterator<E> iterator() {
        readLock.lock();
        try {
            @SuppressWarnings("unchecked")
            ArrayList<E> l = (ArrayList<E>) clone();
            return l.iterator();
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        readLock.lock();
        try {
            return super.subList(fromIndex, toIndex);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        readLock.lock();
        try {
            super.forEach(action);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public Spliterator<E> spliterator() {
        readLock.lock();
        try {
            @SuppressWarnings("unchecked")
            ArrayList<E> l = (ArrayList<E>) clone();
            return l.spliterator();
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        writeLock.lock();
        try {
            return super.removeIf(filter);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {
        writeLock.lock();
        try {
            super.replaceAll(operator);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public void sort(Comparator<? super E> c) {
        writeLock.lock();
        try {
            super.sort(c);
        } finally {
            writeLock.unlock();
        }
    }

    @Override
    public boolean equals(Object o) {
        readLock.lock();
        try {
            return super.equals(o);
        } finally {
            readLock.unlock();
        }
    }

    @Override
    public int hashCode() {
        readLock.lock();
        try {
            return super.hashCode();
        } finally {
            readLock.unlock();
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
    public String toString() {
        readLock.lock();
        try {
            return super.toString();
        } finally {
            readLock.unlock();
        }
    }

}
