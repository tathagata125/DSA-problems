class Solution {
    List<List<Integer>>result;
    public void getSubsequence(int[] nums, int idx, List<Integer> output){
        if(idx == nums.length){
            result.add(new ArrayList<>(output));
            return;
        }
        output.add(nums[idx]);
        getSubsequence(nums, idx+1, output);
        output.remove(output.size() - 1);
        if(output.size() > 0 && output.get(output.size() - 1) == nums[idx])
            return;
        getSubsequence(nums, idx + 1, output);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        result = new ArrayList<>();
        List<Integer>output = new ArrayList<>();
        getSubsequence(nums, 0 ,output );
        return result;
    }
}