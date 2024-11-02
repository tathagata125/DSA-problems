class Solution {
public:
    int jump(vector<int>& nums) {
        int jump= 0, r=0, l=0;
        int furthest ;
        while(r < nums.size()-1){
            furthest = 0;
            for(int i =l; i <= r ; i++){
                furthest = max(furthest , i+nums[i]);
            }
            l=r+1;
            jump += 1;
            r = furthest;
        }
        return jump;
     }
    
    
};