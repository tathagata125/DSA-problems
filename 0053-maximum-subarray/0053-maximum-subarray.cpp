class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int maxicur = 0;
        int res = nums[0];
        for(int i =0; i<nums.size(); i++){
            maxicur = max(maxicur+nums[i],nums[i]);
            res = max(maxicur,res);
        }
        return res;
    }
};