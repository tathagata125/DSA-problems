class MinStack {
    Stack<Long> s ;
    long min = Integer.MAX_VALUE;
    public MinStack() {
        s = new Stack<>();
        
        
    }
    
    public void push(int val) {
        if(val >= min){
            s.push(1l*val);
        }
        else{
            s.push(2l*val - min);
            min = val;
        }
    }
    
    public void pop() {
       if(s.peek() > min){
        s.pop();
       }
       else{
        min = 2*min - s.peek();
        s.pop();
       }

    }
    
    public int top() {
        long top = s.peek();
        if(s.peek() <= min){
            return (int)min;
        }
        else{
            return (int)top;
        }
    }
    
    public int getMin() {
        return (int)min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */