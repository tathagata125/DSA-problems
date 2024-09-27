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
    String multiply(String num2, int d1){
        int c =0;
        int p2 = num2.length()-1;
        StringBuilder str = new StringBuilder();
        while(p2 >=0 || c>0){
            int num = (p2>=0 ? num2.charAt(p2) - '0' : 0) ;
            int prod = num*d1 + c;
            str.append(prod % 10);
            c=prod/10;
            p2--;
        }
        return str.reverse().toString();
    }
    public String multiply(String num1, String num2) {
        int p1 = num1.length() - 1;
        String res = "0";
        int count = 0;
        for(;p1>=0;p1--){
            int d1 = num1.charAt(p1) - '0';
            String temp = multiply(num2,d1); 
            for(int c=0; c<count; c++){
                temp += '0';
            }
            res = addStrings(res,temp); 
            count++;
        }
        if(res.charAt(0) == '0') return "0";
         return res;
    }
}