class Solution {
    List<String>ways;
    String[] s = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    void paths(String digit, int idx, String output){
        if(idx == digit.length()){
            ways.add(output);
            return;
        }

        int su = digit.charAt(idx)-'0' ;
        for(char ch : s[su].toCharArray()){
            paths(digit,idx+1,output+ch);
        }
    }
    public List<String> letterCombinations(String digits) {
      ways = new ArrayList<>();
      if(digits.length() == 0){
        return ways;
      }
      paths(digits,0,"");
      return ways;
    }
}