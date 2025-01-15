class CustomStack {
    int[] arr ;
    int[] incre;
    int top =-1;
    public CustomStack(int maxSize) {
        this.arr = new int[maxSize];
        this.incre = new int[maxSize];
    }
    
    public void push(int x) {
        if(top == arr.length-1){
            return;
        }
        top++;
        arr[top] = x;
        incre[top] = 0;
    }
    
    public int pop() {
        if(top == -1){
            return -1;
        }
        int val = arr[top] + incre[top];
        if(top -1 > -1)incre[top-1] += incre[top];
        top--;
        return val;
        }
    
    public void increment(int k, int val) {
        if(top == -1)return;
        k = Math.min(k,top+1);
        incre[k-1] += val;
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */