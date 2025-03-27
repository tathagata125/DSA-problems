class Solution {
    public int minimumIndex(List<Integer> nums) {
        int ele = 0;
        int vote = 0;
        
        for(int i = 0 ; i < nums.size(); i++){
            if(vote == 0){
                ele = nums.get(i);
                vote++;
            }
            else if(nums.get(i) != ele){
                vote--;
            }
            else{
                vote++;
            }
        }
        int totalCount=0;
        for(int i = 0; i < nums.size(); i++){
            if(ele == nums.get(i))totalCount++;
        }
        
        int cnt = 0;
        for(int i = 0; i < nums.size(); i++){
            if(ele == nums.get(i)){
                cnt++;
            }
            if(cnt * 2 > i+1 && (totalCount - cnt)*2 > (nums.size() - (i+1)) ){
                return i;
            }
            
        }
        
        return -1;
    }
}