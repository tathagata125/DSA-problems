class Solution {
    int giveFloor(int[] arr,int x){
        int l =0;
        int h=arr.length-1;
        while(l <= h){
            int mid = l + (h-l)/2;
            if(arr[mid] >= x){
                h=mid - 1;
            }
            else{
                l=mid + 1;
            }
        }
        return h;
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int floor = giveFloor(arr,x);
        int ceil = floor + 1;
        for(int i=0; i<k ; i++){
            int floorDist = (floor == -1)? (Integer.MAX_VALUE ): x - arr[floor];
            int ceilDist = (ceil == arr.length) ? Integer.MAX_VALUE : arr[ceil] - x;
            if(floorDist <= ceilDist){
                floor--;
            }
            else{
                ceil ++ ;
            }
        }
        List<Integer> res = new ArrayList<>();
        for(int i =floor+1; i<ceil; i++){
            res.add(arr[i]);
        }
        return res;
    }
}