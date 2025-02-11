/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

class Solution {
public:
    int guessNumber(int n) {
        if(n == 1){
            return 1;
        }
        int l =0;
        int h = n-1;
        while(l <= h){
            int mid = l + (h - l)/2;
            if(guess(mid) == 0){
                return mid;
            }
            else if(guess(mid) == 1){
                l = mid + 1;
            }
            else{
                h = mid - 1;
            }
        }
        return l;
    }
};