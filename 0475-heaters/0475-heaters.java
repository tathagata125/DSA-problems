class Solution {
    public int floorClose(int house, int[] heaters){
        int l = 0;
        int r = heaters.length-1;
        while( l <= r){
            int mid = l + (r - l)/2;
            if(heaters[mid] < house){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return r;
    }
    public int findClosest(int house , int[] heaters ){
        int floor = floorClose(house, heaters);
        System.out.println(floor);
        int ceil = floor + 1;
        int floorDest = (floor == -1) ? Integer.MAX_VALUE : house - heaters[floor];
        int ceilDest = ceil == heaters.length ? Integer.MAX_VALUE : heaters[ceil] - house;
        return Math.min(floorDest, ceilDest);
    }
    public int findRadius(int[] houses, int[] heaters) {
        int minRadius = 0;
        Arrays.sort(heaters);
        for(int house : houses){
           int dist =  findClosest(house , heaters);
           minRadius = Math.max(minRadius, dist);
        }
        return minRadius;
    }
}