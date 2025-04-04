class Solution {
    int[] valid(String s){
        int[] arr = new int[26];
        for(char ch : s.toCharArray()){
            arr[ch - 'a']++;
        }
        return arr;
    }
    public boolean isAnagram(String s, String t) {
        int[] ch = valid(s);
        int[] ch1 = valid(t);
        for(int i = 0; i<26; i++){
            if(ch[i] != ch1[i]){
                return false;
            }
        }
        return true; 
    }
}