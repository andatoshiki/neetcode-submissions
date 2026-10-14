class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;
    private int min = Integer.MAX_VALUE;

    public MinStack() {
        this.stack = new ArrayDeque<>();
        this.minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        this.stack.push(val);
        // consider 0, 1, -2, 2 -> 0, 1, -2, 2, -3 -> 0, 1, -2, 2 -> 0, 1, -2, 2
        // reset the min val if minStack top and current min mismatched, because the current min might be -3, but -3 in original stack was already popped, when new stack item added 2, despite the minStack's top is already -2, but the previous min -3 was preserved and added to the minStack which is accurate
        // if (!this.minStack.isEmpty() && this.minStack.peek() != this.min) {
        //     this.min = this.minStack.peek();
        // }
        if (minStack.isEmpty()) {
            this.min = val;
            this.minStack.push(val);
        }
        else {
            this.min = Math.min(this.minStack.peek(), val);
        this.minStack.push(this.min);  
        }
    }
    
    public void pop() {
        this.stack.pop();
        this.minStack.pop();
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        return this.minStack.peek();
    }
}
