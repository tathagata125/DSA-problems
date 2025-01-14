class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() == k)return "0";
         StringBuilder res = new StringBuilder();
         
         
         for(char ch : num.toCharArray()){
            while(res.length() > 0 && res.charAt(res.length() - 1) > ch && k >0){
                res.deleteCharAt(res.length() - 1);
                k--;
            }
            res.append(ch);
         }
         while( k-- > 0){
            res.deleteCharAt(res.length() - 1);
         }
         int idx = 0;
         while(idx < res.length() && res.charAt(idx) == '0'){
            idx++;
         }
         if(idx == res.length()){
            return "0";
         }
         return res.toString().substring(idx);

    }
}