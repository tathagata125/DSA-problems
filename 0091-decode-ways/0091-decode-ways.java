class Solution {
    int decode(String s, int[] dig, int idx){
        if(s.length() == 0){
            return 1;
        }
        if(dig[idx] != 0)return dig[idx];
        if(s.charAt(0) == '0')return 0;
        int one = decode(s.substring(1), dig, idx-1);
        if(s.length() == 1 )return one;
        String st = s.substring(0,2);
        int temp = Integer.parseInt(st);
        if(temp > 26)return one;
        int two = decode(s.substring(2), dig, idx-2);

        return dig[idx] = one + two;
    }
    public int numDecodings(String s) {
        if(s.charAt(0) == '0')return 0;
        int[] dig = new int[s.length()];
        return decode(s,dig,s.length()-1 );
    }
}