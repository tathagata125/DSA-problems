class Solution {
    int i = 0;
    public String decodeString(String s) {
        StringBuilder st = new StringBuilder("");
        int count = 0;
        while(i < s.length() && s.charAt(i) != ']'){
            char ch = s.charAt(i);
            i++;
            if(ch >= '0' && ch <= '9'){
                count = count*10 + (ch - '0');
            } 
            else if(ch == '['){
                String ss = decodeString(s);
                for(int idx =0; idx<count; idx++){
                    st.append(ss);
                }
                count = 0;
            }
            else{
                st.append(ch);
            }
            
        }
        i++;
        return st.toString();
    }
}