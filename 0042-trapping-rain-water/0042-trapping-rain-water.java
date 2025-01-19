class Solution {
    public int trap(int[] height) {
        int[] greatestL = new int[height.length];
        int maxL=0;
        int[] greatestR = new int[height.length];
        int maxR=0;
        for(int i =0; i<height.length;i++){
            
            greatestL[i] = height[i] >= maxL ? 0 : maxL;
            
           
            maxL = Math.max(maxL,height[i]);
            greatestR[height.length - i-1] = height[height.length - i-1] >= maxR ? 0 : maxR;
            maxR = Math.max(maxR,height[height.length - i-1]);
             

        }
        System.out.println("greatest left");
        for(int i =0; i<height.length; i++){
            System.out.println(greatestL[i]);
        }
        System.out.println("greatest right");
        for(int i =0; i<height.length; i++){
            System.out.println(greatestR[height.length-i-1]);
        }
        
        int sum =0;
        for(int i =0; i<height.length; i++){
            height[i] = (Math.min(greatestR[i],greatestL[i]) - height[i]) > 0 ?Math.min(greatestR[i],greatestL[i]) - height[i] : 0;
            sum += height[i];
        }
        return sum;

    }
}