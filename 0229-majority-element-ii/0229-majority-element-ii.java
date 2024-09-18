class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int lead1 =0;
        int lead2 = 0;
        int maja=0 ;
        int majb=0;
        for(int i =0; i<nums.length; i++){
            if(nums[i]==maja){
                lead1++;
            }
            else if(nums[i] == majb){
                lead2++;
            }
            else if(lead1 ==0){
                maja = nums[i];
                lead1=1;
            }
            else if(lead2 == 0){
                majb = nums[i];
                lead2 = 1;
            }
            else{
                lead1--;
                lead2--;
            }
        }
        lead1=0;
        lead2=0;
        for(int i =0; i<nums.length; i++){
            if(nums[i] == maja){
                lead1++;
            }
            else if(nums[i] == majb){
                lead2++;
            }
        }
        List<Integer>ans = new ArrayList<>();
        if(lead1 > nums.length/3 ) ans.add(maja);
        if(lead2 > nums.length/3) ans.add(majb);
        return ans;
        
    }
}