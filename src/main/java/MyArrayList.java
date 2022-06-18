import java.util.Arrays;

public class MyArrayList<T> implements MyArrayListCommand<T> {
    private static final int DEFAULT_SIZE = 10;
    private int userSize;
    private int size = 0;
    private T[] arrayList1;

    public MyArrayList() {
        arrayList1 = (T[]) new Object[DEFAULT_SIZE];
        userSize = DEFAULT_SIZE;
    }

    public MyArrayList(int userSize) {
        this.userSize = userSize;
        arrayList1 = (T[]) new Object[userSize];
    }

    @Override
    public void add(T value) {
        if (size == arrayList1.length) {
            arrayList1 = resizeArray();
        }

        arrayList1[size] = value;
        size++;

    }


    @Override
    public void remove(int index) {
        System.arraycopy(arrayList1, index + 1, arrayList1, index, arrayList1.length - index - 1);
        size--;
        if (size <= arrayList1.length >> 1 && arrayList1.length >= userSize + (userSize >> 1)) {
            arrayList1 = Arrays.copyOf(arrayList1, size + (size >> 1));
        }
    }

    @Override
    public void clear() {
        arrayList1 = (T[]) new Object[userSize];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        try {
            return arrayList1[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            return null;
        }
    }

    private T[] resizeArray() {
        return Arrays.copyOf(arrayList1, arrayList1.length + (arrayList1.length >> 1));
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "arrayList1=" + Arrays.toString(arrayList1) +
                '}';
    }
}
