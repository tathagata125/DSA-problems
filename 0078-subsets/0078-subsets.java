class Solution {
    List<List<Integer>> result;
    public void subSequence(int[] nums, int idx, List<Integer>output){
        if(idx == nums.length){
            result.add(new ArrayList<>(output));
            return;
        }
        output.add(nums[idx]);
        subSequence(nums, idx + 1, output);
        output.remove(output.size() - 1);
        subSequence(nums, idx + 1, output);
    }
    public List<List<Integer>> subsets(int[] nums) {
        result = new ArrayList<>();
        List<Integer> output  = new ArrayList<>();
        subSequence(nums,0,output);
        return result;
    }
}