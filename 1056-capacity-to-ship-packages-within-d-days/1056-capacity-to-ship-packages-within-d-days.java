class Solution {
    boolean isTrue(int mid, int[] weights, int days){
        int required = 1;
        int capacity = mid;
        for(int i = 0 ; i<weights.length; i++){
            if(weights[i] > capacity){
                return false;
            }
            if( weights[i] > mid){
                required++;
                mid = capacity;

            }
            
            mid -= weights[i];
            
        }
        if(required <= days) return true;
        return false;
    }
    public int shipWithinDays(int[] weights, int days) {
        int sum = 0;
        for(int i = 0; i<weights.length; i++){
            sum += weights[i];
        }
        int l =1;
        int r= sum;
        while(l <= r){
            int mid = l + (r- l)/2;
            if(isTrue(mid, weights, days) == true){
                r=mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return l;
    }
}