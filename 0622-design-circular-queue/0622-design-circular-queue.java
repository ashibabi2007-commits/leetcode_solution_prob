class MyCircularQueue {
    private final int[] queue;
    private int front;
    private int size;
    private final int capacity;
    public MyCircularQueue(int k) {
        capacity = k;
        queue = new int[k];
        front = 0;
        size = 0;
    }
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        int insertIndex = (front + size) % capacity;
        queue[insertIndex] = value;
        size++;
        return true;
    }
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % capacity;
        size--;
        return true;
    }
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return queue[front];
    }
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        int rearIndex = (front + size - 1) % capacity;
        return queue[rearIndex];
    }
    public boolean isEmpty() {
        return size == 0;
    } 
    public boolean isFull() {
        return size == capacity;
    }
}