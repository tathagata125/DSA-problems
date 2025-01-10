class Solution {
    public String removeOuterParentheses(String s) {
        boolean[] temp = new boolean[s.length()];
        Stack<Integer> st = new Stack<>();
        for(int i =0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(i);
            }
            else{
                int open = st.pop();
                if(st.size() == 0){
                    temp[open]=temp[i] = true;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for(int i =0; i<s.length(); i++){
            if(temp[i] == false){
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}