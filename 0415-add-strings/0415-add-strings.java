class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder s = new StringBuilder();
        int n1 = num1.length()-1;
        int n2 = num2.length()-1;
        int carry =0;
        while(n1 >=0 || n2 >=0){
            int res =( n1>=0?num1.charAt(n1)-'0': 0) + (n2 >= 0? num2.charAt(n2) - '0':0) + carry;
            s.append(res%10);
            carry = res/10;
            n1--;
            n2--;
        }
        if(carry == 1 && n1 <0 && n2 < 0){
            s.append("1");
        }
        return s.reverse().toString();
    }
}