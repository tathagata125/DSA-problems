class Solution {
    public int minInsertions(String s) {
        int open = 0, addition = 0;
        for(int i =0; i<s.length();i++){
            if(s.charAt(i) == '('){
                open++;
            }
            else{
                if(open > 0) open--;
                else{
                    addition++;
                }
                if(i+1< s.length() && s.charAt(i+1)==')')
                    i++;
                else
                    addition++;
            }
        }
        return 2*open+addition;
    }
}