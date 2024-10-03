class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        char[] map = new char[256];
        int i = 0;
        for(char ch : s.toCharArray()){
            if(map[ch] == '\u0000'){
                map[ch]=t.charAt(i);
                
            }
            else if(map[ch] != t.charAt(i)){
                return false;
            }
            i++;
        }
        i=0;
        for(int j =0; j<256; j++){
            map[j]='\u0000';
        }
        for(char ch : t.toCharArray()){
            if(map[ch] == '\u0000'){
                map[ch]=s.charAt(i);
                
            }
            else if(map[ch] != s.charAt(i)){
                return false;
            }
            i++;
        }
        return true;
    }
}