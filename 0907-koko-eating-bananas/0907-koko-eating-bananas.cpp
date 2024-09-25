class Solution {
public:
    long long hour(long long mid, vector<int>& piles) {
        long long h = 0;
        for(int i = 0; i < piles.size(); i++) {
            h += (piles[i] + mid - 1) / mid;  // Simulate ceiling of integer division
        }
        return h;
    }

    int minEatingSpeed(vector<int>& piles, int h) {
        long long low = 1;
        long long high = *max_element(piles.begin(), piles.end());

        while(low <= high) {
            long long mid = low + (high - low) / 2;

            // Debug output to trace the binary search process
            cout << "low: " << low << ", high: " << high << ", mid: " << mid << ", hours needed: " << hour(mid, piles) << endl;

            if((long long)hour(mid, piles) <=(long long) h) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }
};
