package homework2;

public interface Queue<T> {

    void offer(T value);

    T poll();

    int size();

    boolean isEmpty();

}
