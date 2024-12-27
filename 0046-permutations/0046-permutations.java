class Solution {
    List<List<Integer>> com;
    void getAllCom(int[] nums,List<Integer>output,boolean[] vis){
        if(output.size() == nums.length){
            com.add(new ArrayList<>(output));
            return;
        }
        
        for(int i = 0; i<nums.length;i++){
            if(vis[i] == true){
                continue;
            }
            output.add(nums[i]);
            vis[i] = true;
            getAllCom( nums, output,vis);
            output.remove(output.size()-1);
            vis[i] = false;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        com = new ArrayList<>();
        boolean[] vis = new boolean[nums.length];
        List<Integer>output = new ArrayList<>();
        getAllCom(nums,output,vis);
        return com;
    }
}