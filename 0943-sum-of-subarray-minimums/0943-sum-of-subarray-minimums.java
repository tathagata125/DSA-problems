class Solution {
    public int[] rightNse(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] res = new int[arr.length];
        for(int idx = arr.length-1; idx >= 0; idx--){
            while(st.size() != 0 && arr[st.peek()] >= arr[idx]){
                st.pop();
            }
            res[idx]= st.size() > 0? st.peek() : arr.length;
            st.push(idx);
        }
        return res;
    }
    public int[] leftNse(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] res = new int[arr.length];
        for(int idx = 0; idx < arr.length; idx++){
            while(st.size() != 0 && arr[st.peek()] > arr[idx]){
                st.pop();
            }
            res[idx]= st.size() > 0? st.peek() : -1;
            st.push(idx);
        }
        return res;
    }
    public int sumSubarrayMins(int[] arr) {
        long ans  = 0;
        int[] left = leftNse( arr);
        int[] right = rightNse(arr);
        for(int i = 0; i<arr.length; i++){
            long count = (right[i] - i)*(i - left[i]);
            ans = (ans +(count*arr[i]))%(1000000007);
        }
        return (int)(ans % 1000000007);
    }
}