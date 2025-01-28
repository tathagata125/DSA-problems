class FreqStack {
    HashMap<Integer,Integer>freq = new HashMap<>();
    HashMap<Integer,ArrayList<Integer>>freqNode = new HashMap<>();
    int maxFreq = 0;

    public FreqStack() {
        
    }
    
    public void push(int val) {
        freq.put(val, freq.getOrDefault(val,0)+1);
        int currentFreq = freq.get(val);
        if(freqNode.containsKey(freq.get(val)) == false){
            freqNode.put(currentFreq,new ArrayList<>());
        }
        freqNode.get(currentFreq).add(val);
        if(currentFreq > maxFreq){
            maxFreq = currentFreq;
        }
        
    }
    
    public int pop() {
        ArrayList<Integer> nodes = freqNode.get(maxFreq);
        int max = nodes.get(nodes.size() - 1);
        nodes.remove(nodes.size() - 1);
        freq.put(max,freq.getOrDefault(max,0)-1);
        if(nodes.size() == 0){
            freqNode.remove(maxFreq);
            
            maxFreq--;
        }else{
            freqNode.put(maxFreq,nodes);
        }
        return max;
    }
}

/**
 * Your FreqStack object will be instantiated and called as such:
 * FreqStack obj = new FreqStack();
 * obj.push(val);
 * int param_2 = obj.pop();
 */