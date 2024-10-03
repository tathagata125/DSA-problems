class Solution {
    int [] valid(String s){
        int []freq = new int[26] ;
        for(char ch : s.toCharArray()){
            freq[ch - 'a']++;
        }
        return freq;
    }
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        int [] charArray1 = valid(s);
        int [] charArray2 = valid(t);
        for(int i =0; i<26; i++){
            if(charArray1[i] != charArray2[i]){
                return false;
            }
        }
        return true;
    }
}