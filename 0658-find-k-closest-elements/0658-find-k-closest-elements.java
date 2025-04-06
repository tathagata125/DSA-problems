class Solution {
    int floorel(int[] arr, int x){
        int l = 0;
        int r = arr.length-1;
        while(l <= r){
            int mid = l + (r - l)/2;
            if(arr[mid] < x ){
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        return r;
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> l = new ArrayList<>();
        
        int floor = floorel(arr,x) ;
        System.out.println(floor);
        int ceil = floor+1;
        for(int i = 0; i < k; i++){
            int floordest =floor < 0?Integer.MAX_VALUE: (x-arr[floor]);
            int ceildest = ceil ==arr.length? Integer.MAX_VALUE: arr[ceil] - x;
            if(floordest <= ceildest){
                floor--;
            }
            else{
                ceil++;
            }
        }
        
        for(int i = floor+1; i < ceil ; i++){
            l.add(arr[i]);
        }
        return l;
    }
}