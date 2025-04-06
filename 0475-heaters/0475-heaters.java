class Solution {
    int floor(int[] array, int target){
        int l =0; 
        int h=array.length -1 ;
        while(l <= h){
            int mid = l+ (h-l)/2 ;
            if(array[mid] >= target){
                h = mid  - 1;
            }
            else{
                l= mid + 1;
            }
        }
        return h;
    }
    int radius(int[] heaters, int target){
        int findFloor = floor(heaters,target);
        int ceil = findFloor + 1;
        int floorDest = findFloor == -1 ? Integer.MAX_VALUE : target - heaters[findFloor];
        int ceilDest = ceil == heaters.length ? Integer.MAX_VALUE : heaters[ceil] - target;
        return Math.min(floorDest,ceilDest);
    }
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(heaters);
        int minRadius = 0;
        for(int house : houses){
            int radius = radius(heaters, house);
            minRadius = Math.max(minRadius,radius);
        }
        return minRadius;
    }
}