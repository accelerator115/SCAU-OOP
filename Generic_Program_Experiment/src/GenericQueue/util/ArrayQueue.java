package GenericQueue.util;

public class ArrayQueue<E> {
    private final Object[] elements;
    private final int capacity;
    private int head;
    private int tail;
    private int size;

    public ArrayQueue() {
        this(16);
    }

    @SuppressWarnings("unchecked")
    public ArrayQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("容量必须为正整数");
        }
        this.capacity = capacity;
        this.elements = new Object[capacity];
        this.head = 0;
        this.tail = 0;
        this.size = 0;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == capacity;
    }

    public void add(E e) {
        if (isFull()) {
            throw new IllegalStateException("队列已满，无法添加元素");
        }
        elements[tail] = e;
        tail = (tail + 1) % capacity;// 环形队列
        size++;
    }

    public E remove() {
        if (isEmpty()) {
            return null;
        }
        E result = (E) elements[head];
        elements[head] = null;
        head = (head + 1) % capacity;
        size--;
        return result;
    }
}
