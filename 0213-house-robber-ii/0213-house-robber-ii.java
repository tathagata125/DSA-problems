class Solution {
    int ways(int[] nums, int start, int end, int[][] mem,int prev){
        if(start > end)return 0;
        if(mem[start][prev] != -1)return mem[start][prev];
        int notTaken = ways(nums,start+1,end,mem,0);
        if(prev != 0)return mem[start][prev]= notTaken;
        int taken = ways(nums,start+1,end,mem,1)+nums[start];
        return mem[start][prev] = Math.max(notTaken,taken);

    }
    int cr(int[] nums, int start, int end ){
        int[][] mem = new int[nums.length][2];
        for(int i = 0; i < nums.length; i++){
            mem[i][0] = -1;
            mem[i][1] = -1;
        }
        return ways(nums,start,end,mem,0);
    }
    public int rob(int[] nums) {
        
        if(nums.length == 1)return nums[0];
        return Math.max(cr(nums,0,nums.length-2),cr(nums,1,nums.length-1));
    }
}