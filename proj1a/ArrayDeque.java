public class ArrayDeque<T> {
    private T[] array;
    private int size;
    private double percentage = 0.25;
    private int addFirstTime;

    public ArrayDeque() {
        array = (T[]) new Object[8];
        size = 0;
        addFirstTime = 0;
    }

    private void resize(int newSize) {
        T[] newArray = (T[]) new Object[newSize];
        System.arraycopy(array, array.length - addFirstTime - 1, newArray, 0, addFirstTime);
        System.arraycopy(array, 0, newArray, addFirstTime, size - addFirstTime);
        array = newArray;
        addFirstTime = 0;
    }

    public void addFirst(T item) {
        if (size == array.length) {
            resize(array.length * 2);
        }
        array[array.length - addFirstTime - 1] = item;
        size++;
        addFirstTime++;
    }

    public void addLast(T item) {
        if (size == array.length) {
            resize(array.length * 2);
        }
        array[size - addFirstTime] = item;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        for (int i = 0; i < addFirstTime; i++) {
            System.out.print(array[array.length - addFirstTime + i] + " ");
        }
        for (int j = 0; j < size - addFirstTime; j++) {
            System.out.print(array[j] + " ");
        }
        System.out.println();
    }

    public T removeFirst() {
        if (size == 0) {
            return null;
        }else {
            T item = array[array.length - addFirstTime - 1];
            size--;
            addFirstTime--;
            if (array.length >= 16 && (double) size / array.length < percentage) {
                resize(array.length / 2);
            }
            return item;
        }
    }

    public T removeLast() {
        if (size == 0) {
            return null;
        }else {
            T item = array[size - addFirstTime - 1];
            size--;
            if (array.length >= 16 && (double) size / array.length > percentage) {
                resize(array.length / 2);
            }
            return item;
        }
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            return null;
        }
        return (index < addFirstTime) ? array[array.length - addFirstTime - 1 + index] : array[index - addFirstTime];
    }

}
