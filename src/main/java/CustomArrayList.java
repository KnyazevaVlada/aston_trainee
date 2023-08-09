import java.util.*;

public class CustomArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] data;
    private int size;

    public CustomArrayList() {
        data = new Object[DEFAULT_CAPACITY];
    }

    public CustomArrayList(int capacity) {
        data = new Object[capacity];
    }

    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        ensureCapacity(size + 1);
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
        size++;
    }

    public boolean addAll(Collection<? extends E> c) {
        ensureCapacity(size + c.size());
        boolean modified = false;
        for (E e : c) {
            data[size++] = e;
            modified = true;
        }
        return modified;
    }

    public void clear() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return (E) data[index];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        E removedElement = (E) data[index];
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        size--;
        return removedElement;
    }

    public boolean remove(Object o) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(o)) {
                System.arraycopy(data, i + 1, data, i, size - i - 1);
                size--;
                return true;
            }
        }
        return false;
    }

    public void quickSort(Object[] array, int low, int high) {
        if (array.length == 0) return;
        if (low > high) return;

        int middle = low + (high - low) / 2;
        int prop = (int) array[middle];

        int i = low, j = high;
        while (i <= j) {
            while ((int) array[i] < prop) {
                i++;
            }

            while ((int) array[j] > prop) {
                j--;
            }

            if (i <= j) {
                int temp = (int) array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }

    private void ensureCapacity(int minCapacity) {
        if (minCapacity > data.length) {
            int newCapacity = Math.max(data.length * 2, minCapacity);
            data = Arrays.copyOf(data, newCapacity);
        }
    }
}
