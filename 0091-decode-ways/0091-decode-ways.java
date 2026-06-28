class Solution {
    
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[s.length()]= 1;
        for(int i = s.length() -1 ; i >= 0 ; i--){
            if(s.charAt(i) != '0')
                dp[i] += dp[i+1];
            
            if(i+1 < s.length()){
                int temp = (s.charAt(i)- '0')*10 + (s.charAt(i+1)- '0');
                if(temp >= 10 && temp <= 26){
                    dp[i] += dp[i+2];
                }
            }
        } 
        return dp[0];
    }
}