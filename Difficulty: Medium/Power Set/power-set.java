// User function Template for Java

class Solution {
    List<String> powerset(String s, int idx){
        if(idx == s.length()){
            List<String> st = new ArrayList<>();
            st.add("");
            return st;
        }
        List<String> result = powerset(s, idx+1);
        int n = result.size();
        for(int i = 0; i < n ; i++){
            String res = s.charAt(idx) + result.get(i);
            result.add(res);
        }
        return result;
        
    }
    public List<String> AllPossibleStrings(String s) {
        // Code here
        
        List<String> res =powerset(s,0);
        Collections.sort(res);
        return res;
    }
}