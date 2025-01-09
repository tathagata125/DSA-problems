class MyStack {
   Queue<Integer> q = new ArrayDeque<>();
    
    
    public void push(int x) {
       q.add(x); 
    }
    
    public int pop() {
        int size = q.size() - 1;
        while(size != 0){
            int temp = q.remove();
            q.add(temp);
            size --;
        }
        return q.remove();
    }
    
    public int top() {
        int size = q.size() - 1;
        while(size != 0){
            int temp = q.remove();
            q.add(temp);
            size --;
        }
        int temp = q.remove();
        q.add(temp);
        return temp;
    }
    
    public boolean empty() {
        if(q.size() == 0){
            return true;
        }
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */