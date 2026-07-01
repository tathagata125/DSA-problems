class Solution {
    int ways(int[] coins, int amount, int[] memo) { // Removed idx here
        if (amount == 0) return 0;
        if (amount < 0) return Integer.MAX_VALUE;
        if (memo[amount] != 0) return memo[amount];

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            // Removed passing 'i' as idx here
            int res = ways(coins, amount - coins[i], memo); 
            if (res != Integer.MAX_VALUE) {
                min = Math.min(min, res);
            }
        }

        if (min < Integer.MAX_VALUE) {
            return memo[amount] = min + 1;
        }
        return memo[amount] = Integer.MAX_VALUE;
    }

    public int coinChange(int[] coins, int amount) {
        int[] memo = new int[amount + 1];
        int call = ways(coins, amount, memo); // Removed 0 here
        if (call == Integer.MAX_VALUE) return -1;
        return call;
    }
}