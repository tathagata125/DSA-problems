class Solution {
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;
        int maxL = 0;
        int maxR= height.length-1; 
        int maxi = 0;
        while(l <= r){
            if(height[l] <= height[r]){
                
                    maxi = Math.max(maxi, (r-l )*height[l] );
                
                l++;
            }
            else{
                
                    maxi = Math.max(maxi , (r-l)*height[r]);
                
                    maxR = r;
                
                r--;
            }
        }
        return maxi;
    }
}