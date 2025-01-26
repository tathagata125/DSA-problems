class Solution {
    public int twoCitySchedCost(int[][] costs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (t,o) -> {
                int profit1 = t[1] - t[0];
                int profit2 = o[1] - o[0];
                if(profit1 > profit2 )return -1;
                else if(profit1 < profit2) return 1;
                else return 0;
            }
        );
        int half = costs.length/2;
        for(int[] pair : costs){
            pq.add(pair);
        }
        int sum = 0;
        for(int i = 0; i < costs.length ; i++){
            int[] res = pq.remove();
            if(half > 0){
                sum += res[0];
                half--;
            }
            else{
                sum += res[1];
            }
        }
        return sum;
    }
}