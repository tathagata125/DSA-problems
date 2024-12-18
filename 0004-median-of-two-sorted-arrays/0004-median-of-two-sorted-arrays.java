class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        int n = nums1.length + nums2.length ;
        int nBy2 = (n + 1)/2;
        int l = 0;
        int h= nums1.length;
        while(l <= h){
            int mid = l + (h - l)/2;
            int al = mid - 1 >= 0 ? nums1[mid - 1] : Integer.MIN_VALUE;
            int ar = mid < nums1.length ? nums1[mid] : Integer.MAX_VALUE;
            int bl = nBy2 - mid - 1 >= 0 ? nums2[nBy2 - mid - 1] : Integer.MIN_VALUE;
            int br = nBy2 - mid < nums2.length ? nums2[nBy2 - mid] : Integer.MAX_VALUE;
            if(al <= br && bl <= ar ){
                if(n % 2 == 0){
                    int[] arr = {al, ar, bl, br};
                    Arrays.sort(arr);
                    return (arr[1] + arr[2])/2.0;

                }
                else{
                    return Math.max(al, bl);
                }
            }
            if(al > br){
                h= mid -1;
            }
            else if(bl > ar){
                l = mid + 1;
            }
        }
        return 0;
    }
}