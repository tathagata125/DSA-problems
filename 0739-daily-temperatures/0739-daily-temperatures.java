class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
       Stack<Integer> st = new Stack<>();
       int[] arr = new int[temperatures.length];
       for(int i = 0; i< temperatures.length; i++){
           while(st.size()!= 0 && temperatures[st.peek()] < temperatures[i]){
                int temp = st.pop();
                arr[temp] = i-temp; 
           }
           st.push(i);
       }
       return arr; 
    }
}