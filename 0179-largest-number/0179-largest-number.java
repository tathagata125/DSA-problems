class Solution {
    public String largestNumber(int[] nums) {
        List<String> res = new ArrayList<>();
        for(int val: nums){
            res.add(Integer.toString(val));
        }
        Collections.sort(res,(o,t) ->(t+o).compareTo(o+t));
        StringBuilder s = new StringBuilder();
        for(String str : res)s.append(str);
        if(s.charAt(0) == '0')return "0";
        return s.toString();
    }
}