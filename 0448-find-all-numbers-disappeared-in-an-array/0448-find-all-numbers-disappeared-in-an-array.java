class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i =0; i<nums.length; i++){
            if((nums[i]%nums.length+1) <= nums.length);
            nums[(nums[i] % (nums.length+1))- 1 ]+= nums.length+1 ;
            System.out.print((nums[i] % (nums.length+1))-1);
            System.out.println(nums[(nums[i] % (nums.length+1))-1]);
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        for(int i =0; i<nums.length; i++){
            int freq = nums[i]/(nums.length+1);
            if(freq == 0){
                list.add(i+1);
            }
        }
        return list;
    }
}