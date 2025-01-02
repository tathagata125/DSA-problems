class Solution {
    int circular(int n, int k){
        if(n == 1) return 0;
        return (circular(n-1,k) + k)% n;
    }
    public int findTheWinner(int n, int k) {
     return circular(n,k)+1;
    }
}