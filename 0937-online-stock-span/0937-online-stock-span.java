class StockSpanner {
    Stack<Integer> st = new Stack<>();
    ArrayList<Integer> arr = new ArrayList<>();
    public StockSpanner() {
        
    }
    
    public int next(int price) {
         
         
         
            while(st.size() != 0 && arr.get(st.peek())<= price){
                  st.pop();
             }
             
         
         int span = (st.size()) > 0 ? arr.size() - st.peek() : arr.size() + 1;
         st.push(arr.size());
         arr.add(price);
         return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */