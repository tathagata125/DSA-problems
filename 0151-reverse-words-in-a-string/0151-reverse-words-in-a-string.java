class Solution {
    public String reverseWords(String s) {
        String[] words = s.trim().split("\s+");
        StringBuilder str = new StringBuilder();
        for(int i =words.length-1; i>=0; i--){
            if(i != words.length - 1 ){
                str.append(" ");
            }
            str.append(words[i]);
        }
        return str.toString();
    }
}