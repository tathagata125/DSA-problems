class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] c1 = word1.toCharArray();
        char[] c2 = word2.toCharArray();
        StringBuilder s = new StringBuilder();
        int s1 = 0;
        int s2 = 0;
        int i = 0;
        while(s1 < c1.length && s2 < c2.length){
            if( i%2 == 0){
                s.append(c1[s1++]);
            }
            else{
                s.append(c2[s2++]);
            }
            i++;
        }
        while(s1 < c1.length){
            s.append(c1[s1++]);
        }
        while(s2 < c2.length){
            s.append(c2[s2++]);
        }
        return s.toString();
    }
}