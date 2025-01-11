class Solution {
    public String minRemoveToMakeValid(String s) {
        boolean[] unbalanced = new boolean[s.length()];
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                st.push(i);
                unbalanced[i] = true;
            }
            else if(s.charAt(i) == ')'){
                if(st.size() == 0){
                    unbalanced[i]=true;
                }
                else{
                    unbalanced[st.pop()]=false;
                }
            }
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0; i<s.length(); i++){
            if(unbalanced[i] == false){
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}