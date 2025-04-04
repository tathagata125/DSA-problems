class Solution {
    public String addStrings(String num1, String num2) {
        int i = num1.length()-1; 
        int j = num2.length()-1;
        int carry = 0;
        StringBuilder s = new StringBuilder();
        while(i >=0 || j >=0){
            int sum = (i >= 0 ?num1.charAt(i)- '0' : 0) + (j>= 0? num2.charAt(j) - '0': 0) + carry;
            
            i--;
            j--;
            s.append(sum%10);
             carry = sum/10;
            
        }
        if(carry > 0){
            s.append(carry);
        }
        return s.reverse().toString();
    }
}