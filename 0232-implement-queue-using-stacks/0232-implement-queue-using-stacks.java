class MyQueue {
    Stack<Integer> actual = new Stack<>();
    Stack<Integer> extra = new Stack<>();
    
    
    public void push(int x) {
        actual.push(x);
    }
    
    public int pop() {
        while(actual.size() != 0){
           extra.push( actual.pop());
        }
        int temp =extra.pop();
        if(extra.size() == 0){
            return temp;
        }
        while(extra.size() != 0){
            actual.push(extra.pop());
        }
        return temp;
    }
    
    public int peek() {
        while(actual.size() != 0){
           extra.push( actual.pop());
        }
        int temp = extra.peek();
        while(extra.size() != 0){
            actual.push(extra.pop());
        }
        return temp;
    }
    
    public boolean empty() {
        if(actual.size() == 0){
            return true;
        }
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */