class Solution {
    List<List<Integer>> res;
    void sub(int[] nums, int idx, List<Integer>output){
        if(idx == nums.length){
            res.add(new ArrayList<>(output));
            return;
        }
        output.add(nums[idx]);
        sub(nums, idx+1,output);
        output.remove(output.size()-1);
        sub(nums, idx+1,output);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> output = new ArrayList<>();
        res = new ArrayList<>();
        sub(nums,0,output);
        return res;
    }
}