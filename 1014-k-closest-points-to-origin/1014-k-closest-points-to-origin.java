class Solution {
    
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]>pq = new PriorityQueue<>(
            (t,o)->{
                double p1 = Math.sqrt(t[0]*t[0] + t[1]*t[1]);
                double p2 = Math.sqrt(o[0]*o[0] + o[1]*o[1]);
                if(p1 > p2)return -1;
                else if(p1 < p2) return 1;
                else return 0;
            }
        );
        for(int[] pair: points){
            int[] p = new int[2];
            int s=0;
            int e = 0;
            double d=0.0 ;
            if(pq.size() != 0){
                 p = pq.peek();
                 s=p[0];
                 e=p[1];
                 d = Math.sqrt(s*s + e*e);
            }
            if(pq.size() < k){
                pq.add(pair);
            }else if(Math.sqrt(pair[0]*pair[0] + pair[1]*pair[1]) < d){
                pq.remove();
                pq.add(pair);
            }
        }
        int[][] arr = new int[k][2];
        for(int i = k-1; i>=0; i--){
            int[] p = pq.remove();
            arr[i][0] = p[0];
            arr[i][1] = p[1];
        }
        return arr;
        
        
    }
}