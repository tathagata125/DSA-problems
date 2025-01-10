class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(char ch : s.toCharArray()){
            if(ch == '(' || ch == '[' || ch == '{'){
                st.push(ch);
            }
            else{
                if(st.size() == 0)return false;
                if(ch == ')' && st.peek() == '(')st.pop();
                else if(ch == '}' && st.peek() == '{')st.pop();
                else if(ch == ']' && st.peek() == '[')st.pop();
                else{
                    return false;
                }
            }
        }
        if(st.size() > 0)return false;
        return true;
    }
}