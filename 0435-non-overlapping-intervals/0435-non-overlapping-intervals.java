class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals , (a,b)->{
            if(a[0] > b[0])return -1;
            else if(a[0] < b[0])return 1;
            else return 0;
            
        });
        int removal = 0;
        int max = Integer.MAX_VALUE;
        for(int[]arr: intervals){
            if(max== Integer.MAX_VALUE){
                max=arr[0];
            }
            else if(arr[1] <= max){
                max=arr[0];
            }
            else if(arr[1] > max){
                removal++;
            
            }
        }
        return removal;
    }
}