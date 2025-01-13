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
            while(st.size() != 0 && arr[st.peek()] >= arr[idx]){
                st.pop();
            }
            res[idx]= st.size() > 0? st.peek() : -1;
            st.push(idx);
        }
        return res;
    }
    public int largestRectangleArea(int[] heights) {
        int[] left = leftNse(heights);
        int[] right = rightNse(heights);
        int max=0;
        for(int i =0; i<heights.length; i++){
            int area = heights[i]*(right[i] - left[i] - 1);
            max = Math.max(max,area);
        }
        return max;
    }
}