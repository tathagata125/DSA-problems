class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        int[] arr = new int[s.length()];
        int max = 0;
        for(int i =0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' ){
                st.push(i);
            }
            else{
                if(st.size() == 0)continue;
                int open = st.pop();
                 arr[i] = i - open + 1;
                if(open > 0)arr[i]  += arr[open-1];
            }
            max = Math.max(max,arr[i]);
        }
        return max;
    }
}