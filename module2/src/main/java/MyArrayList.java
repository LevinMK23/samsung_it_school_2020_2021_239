import java.util.Iterator;

public class MyArrayList<T> implements MyList<T> {

    private static final int DEFAULT_CAPACITY = 5;

    private Object[] data;
    private int size;
    private int capacity;
    private int iteratorPtr;

    public MyArrayList() {
        size = 0;
        capacity = DEFAULT_CAPACITY;
        data = new Object[capacity];
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public void add(T value) {
        validateCapacity();
        data[size] = value;
        size++;
    }

    private void validateCapacity() {
        if (size >= capacity) {
            capacity *= 2;
            System.out.println("new capacity = " + capacity);
            Object[] tmp = new Object[capacity];
            if (size >= 0) {
                System.arraycopy(data, 0, tmp, 0, size);
            }
            data = tmp;
        }
    }

    @Override
    public void add(int idx, T value) {
        if (idx > size || idx < 0) {
            throw new IndexOutOfBoundsException("try to add value by idx = " + idx);
        }
        validateCapacity();
        if (size - idx >= 0) {
            System.arraycopy(data, idx, data, idx + 1, size - idx);
        }
        data[idx] = value;
        size++;
    }

    @Override
    public void remove(T value) {
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                if (data[i].equals(value)) {
                    if (size - 1 - i >= 0) {
                        System.arraycopy(data, i + 1, data, i, size - 1 - i);
                    }
                    break;
                }
            }
        } else {
            throw new IndexOutOfBoundsException("Remove from empty list");
        }
        size--;
    }

    @Override
    public void remove(int idx) {
        if (idx < 0 || idx > size) {
            throw new IndexOutOfBoundsException("try to remove value by idx = " + idx);
        }
        if (size - 1 - idx >= 0) {
            System.arraycopy(data, idx + 1, data, idx, size - 1 - idx);
        }
        size--;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T get(int idx) {
        return (T) data[idx];
    }

    @Override
    public boolean contains(T value) {
        return false;
    }

    @Override
    public void set(int idx, T value) {
        data[idx] = value;
    }

    @Override
    public Iterator<T> iterator() {

        iteratorPtr = 0;
        return new Iterator<T>() {

            @Override
            public boolean hasNext() {
                return iteratorPtr < size;
            }

            @SuppressWarnings("unchecked")
            @Override
            public T next() {
                return (T) data[iteratorPtr++];
            }
        };
    }
}
