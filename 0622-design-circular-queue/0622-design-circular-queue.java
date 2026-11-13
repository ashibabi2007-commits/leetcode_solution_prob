class MyCircularQueue {
    private int[] data;
    private int head;
    private int capacity;
    private int size;
    public MyCircularQueue(int k) {
        this.head=0;
        this.size=0;
        this.capacity=k;
        this.data=new int[k];
    }
    public boolean enQueue(int value) {
        if(isFull()){
            return false;
        }
        int tail=(head+size)%capacity;
        data[tail]=value;
        size++;
        return true;
    }
    public boolean deQueue() {
        if(isEmpty()){
            return false;
        }
        head=(head+1)%capacity;
        size--;
        return true;
    }
    
    public int Front() {
        if(isEmpty()){
            return -1;
        }
        return data[head];
    }
    
    public int Rear() {
        if(isEmpty()){
            return -1;
        }
        int tail=(head+size-1)%capacity;
        return data[tail];
    }
    
    public boolean isEmpty() {
        return (size==0);
    }
    
    public boolean isFull() {
        return (size==capacity);
    }
}

