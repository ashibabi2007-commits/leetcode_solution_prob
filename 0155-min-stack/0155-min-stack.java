class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> minstack;
    public MinStack() {
        stack=new ArrayDeque<>();
        minstack=new ArrayDeque<>();
    }
    
    public void push(int value) {
        stack.push(value);
        if(minstack.isEmpty()||value<=minstack.peek()){
            minstack.push(value);
        }
    }
    
    public void pop() {
        if(stack.pop().equals(minstack.peek())){
            minstack.pop();
        }
    }
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minstack.peek();
    }
}