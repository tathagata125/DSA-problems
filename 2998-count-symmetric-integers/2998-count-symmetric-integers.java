class Solution {
    public int countSymmetricIntegers(int low, int high) {
        int count = 0;
        for(int i = low ; i<= high ;i++){
            String s = String.valueOf(i);
            if(s.length()%2 == 0 ){
                int prefix = 0;
                int suffix = 0;
                for(int j = 0 ; j < s.length()/2; j++){
                    prefix += s.charAt(j) - '0';
                    suffix += s.charAt(s.length() - 1 - j) - '0';
                }
                if(prefix == suffix)count++;
            }
        }
        return count;
    }
}