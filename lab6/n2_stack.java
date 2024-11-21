package lab6;

public class n2_stack<T> {
    private T[] data;
    private int size;

    public n2_stack(int capacity) {
        data = (T[]) new Object[capacity];
        size = 0;
    }

    public void push(T element) {
        if (size == data.length) {
            throw new RuntimeException("Стек переполнен");
        }

        data[size++] = element;
    }

    public T pop() {
        if (isEmpty()) {
            throw new RuntimeException("Стек пуст");
        }

        return data[--size];
    }

    public T peek() {
        if (isEmpty()) {
            throw new RuntimeException("Стек пуст");
        }

        return data[size - 1];
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
