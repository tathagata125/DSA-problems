/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 0;
        int h = n;
        int mid ;
        
        while(l <= h){
            mid = l  + (h - l)/2;
            if(isBadVersion(mid) == false){
                l = mid + 1;
            }
            else{
                h = mid - 1;
            }
        }
        return l;
    }
}