class Solution {
    public int[] nextGreaterElements(int[] arr) {
        Stack<Integer> st = new Stack<>();
         int[] a = new int[arr.length];
         Arrays.fill(a,-1);
         for(int i =0 ; i<arr.length; i++){
             while(st.size() != 0 && arr[st.peek()]< arr[i]){
                 a[st.pop()] = arr[i];
             }
             st.push(i);
         }
         for(int i = 0; i<arr.length; i++){
            while(st.size() != 0 && arr[st.peek()] < arr[i]){
                a[st.pop()] = arr[i];
            }
            
        }
        return a;
    }
}