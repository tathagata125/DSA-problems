class Solution {
    public String addStrings(String num1, String num2) {
        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;
        int c =0;
        StringBuilder str = new StringBuilder();
        while(n1 >= 0 && n2 >=0 ){
            int num = ((num1.charAt(n1) - '0') + (num2.charAt(n2) - '0'))+ c;
            str.append(num%10);
            c=num/10;
            n1--;
            n2--;
        }
       
        while(n1>=0){
            int num = (num1.charAt(n1) - '0') + c;
            str.append(num%10);
            c = num/10;
            n1--;
        }
        while(n2>=0){
            int num = (num2.charAt(n2) - '0') + c;
            str.append(num%10);
            c = num/10;
            n2--;
        }
         if(c == 1 && n1 < 0 && n2 < 0){
            str.append(1);
        }
        str.reverse();
        return str.toString();
    }
}