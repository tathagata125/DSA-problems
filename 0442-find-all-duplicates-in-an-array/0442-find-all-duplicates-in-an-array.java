class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        for(int i = 0; i < nums.length; i++){
            int original = nums[i]%(n+1);
            nums[original-1] += (n+1); 
        }
        List<Integer> l = new ArrayList<>();
        for(int i = 0; i < n; i++){
            int freq = nums[i]/(n+1);
            if(freq > 1){
                l.add(i+1);
                nums[i]=nums[i]%(n+1);
            }
        }
        return l;
    }
}