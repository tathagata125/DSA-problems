class Solution {
     public static int precedence(char c){
        if(c == '*' || c == '/'){
            return 2;
        }
        return 1;
    }
    public static int evaluate(int a, char o, int b){
        if(o == '+'){
            return a+b;
        }
        if(o == '-'){
            return a-b;
        }
        if(o == '*')
            return a*b;
        
        return a/b;
    }
    public String refine(String s){
        StringBuilder str = new StringBuilder();
        for(int i =0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == ' ')continue;
            if(ch == '+'){
                if(str.length() == 0 || str.charAt(str.length() - 1) == '('){
                    str.append("0+");

                }else if(str.charAt(str.length() - 1) == '+' || str.charAt(str.length()-1)
                 == '-')continue;
                 else str.append('+');
            }
            else if(ch == '-'){
                if(str.length() == 0 || str.charAt(str.length()-1) == '('){
                    str.append("0-");
                }
                else if(str.charAt(str.length() - 1) == '+')str.setCharAt(str.length()-1,'-');
                else if(str.charAt(str.length()-1)=='-')str.setCharAt(str.length()-1,'+');
                else str.append('-');
            }
            else{
                str.append(ch);
            }
        }
        return str.toString();
    }

    public int calculate(String s) {
        String expression = refine(s);
        Stack<Integer>ope = new Stack<>();
        Stack<Character>opr = new Stack<>();
        for(int i =0; i<expression.length(); i++){
            if(expression.charAt(i) >= '0' && expression.charAt(i) <= '9'){
                int num = expression.charAt(i)-'0';
                i++;
                while(i < expression.length() && expression.charAt(i) >= '0' && expression.charAt(i)<= '9'){
                     num = num*10 + expression.charAt(i) - '0';
                     i++;
                }
                ope.push(num);
                i--;

            }
            else if(expression.charAt(i) == '('){
                opr.push(expression.charAt(i));
                
            }
            else if(expression.charAt(i) == ')'){
                while(opr.size() != 0 && opr.peek() != '('){
                    int b = ope.pop();
                    int a = ope.pop();
                    char o = opr.pop();
                    int res = evaluate(a,o,b);
                    ope.push(res);
                }
                opr.pop();
            }
            else if(expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*' || expression.charAt(i) == '/'){
                while(opr.size() != 0 && opr.peek() != '(' && precedence(opr.peek()) >= precedence(expression.charAt(i))){
                    int b = ope.pop();
                    int a = ope.pop();
                    char o = opr.pop();
                    int res = evaluate(a,o,b);
                    ope.push(res);
                }
                opr.push(expression.charAt(i));
            }
        }
        while(opr.size() != 0){
                    int b = ope.pop();
                    int a = ope.pop();
                    char o = opr.pop();
                    int res = evaluate(a,o,b);
                    ope.push(res);
        }
        return ope.peek();
    }
}