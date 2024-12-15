class Solution {
    boolean isPossible(int[] nums, int allowStud, int lim){
        int student = 1;
        int currLoad = 0;
        for(int pages: nums){
            if((currLoad + pages ) <= lim){
                currLoad += pages;
            }
            else{
                currLoad = pages;
                student++;
            }
        }
        return (student <= allowStud);
    }
    int sum(int[] sums){
        int sum = 0;
        for(int i =0; i < sums.length; i++){
            sum += sums[i];
        }
        return sum;
    }
    public int splitArray(int[] nums, int k) {
        int l = Arrays.stream(nums).max().getAsInt();
        int r = sum(nums);
        while(l <= r){
            int mid = l + (r - l)/2 ;
            if(isPossible(nums, k, mid)){
                r = mid - 1;
            }
            else{
                l = mid + 1;
            }
        }
        return l;
    }
}