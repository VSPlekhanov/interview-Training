package homework2;

import java.util.Arrays;

public class ArrayStack<T> implements Stack<T> {
    private static final int DEFAULT_CAPACITY = 10;
    private Object[] values = new Object[DEFAULT_CAPACITY];
    private boolean isEmpty = true;
    private int size;

    public void push(T value){
        int currentCapacity = values.length;
        if (size == currentCapacity){
            values = Arrays.copyOf(values, currentCapacity + currentCapacity >> 1 );
        }
        values[size++] = value;
        if (isEmpty) {
            isEmpty = false;
        }
    }

    @SuppressWarnings("unchecked")
    public T pop(){
        if (isEmpty){
            return null;
        }
        if (size == 1){
            isEmpty = true;
        }
        return (T) values[--size];
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public int size() {
        return size;
    }
}
