class Solution {
    List<List<Integer>> com;
    void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    void getAllCom(int[] nums,int idx){
        if(idx == nums.length){
            List<Integer>output = new ArrayList<>();
            for(int val: nums){
                output.add(val);
            }
            com.add(output);
            return;
        }
        
        for(int j = idx; j<nums.length;j++){
            
            swap(nums,idx,j);
           
            getAllCom( nums,idx+1);
            
            swap(nums,idx,j);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        com = new ArrayList<>();
        getAllCom(nums,0);
        return com;
    }
}