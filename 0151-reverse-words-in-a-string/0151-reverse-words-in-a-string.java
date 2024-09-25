class Solution {
    public String reverseWords(String s) {
        int left;
        int right = s.length() - 1;
        StringBuilder str = new StringBuilder();
        while(right >=0){
            while(right >=0 && s.charAt(right) == ' '){
                right -=1;
            }
            left = right;
            while(left >= 0 && s.charAt(left) != ' '){
                left = left -1;
            }
            if(str.length() != 0 && right >= 0){
                str.append(" ");
            }
            for(int i =left+1; i<=right;i++){
               str.append(s.charAt(i));
            }
            right = left;
            
        }
        return str.toString();
    }
}