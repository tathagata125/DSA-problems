class Solution {
public:
    bool canJump(vector<int>& nums) {
        int maxi = 0;
    if(nums.size() == 1 && nums[0] > 0){
        return true;
    }
    else if(nums.size() == 1 && nums[0] == 0){
        return true;
    }
     for(int i=0; i<nums.size();i++){
        maxi = max(maxi,i+nums[i]);
        if(maxi == i+nums[i] && i+nums[i] == i){
            return false;
        }
        if(maxi >= nums.size()-1){
            return true;
        }
     }
     return false; 
    }
};