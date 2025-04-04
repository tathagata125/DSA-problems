class Solution {
    boolean valid(String s, String t){
        if(s.length() != t.length())return false;
        char[] arr = new char[256];
        for(int i = 0; i < s.length(); i++){
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if(arr[c1] != '\u0000' && arr[c1] != c2 )return false;
            arr[c1] = c2;
        }
        return true;
    }
    public boolean isIsomorphic(String s, String t) {
        return valid(s,t) && valid(t,s);
    }
}