class Solution {
    class Pair implements Comparable<Pair>{
        int start;
        int end;
        Pair(int start, int end){
            this.start = start;
            this.end = end;
        }
        public int compareTo(Pair other){
            if(this.start < other.start)return -1;
            else if(this.start > other.start)return +1;
            else return 0;
        }
    }
    public int countDays(int days, int[][] meetings) {
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        for(int[] intervals : meetings){
            pq.add(new Pair(intervals[0], intervals[1]));
        }
        List<Pair> ans = new ArrayList<>();
        while(pq.size() > 0){
            Pair current = pq.remove();
            Pair last = ans.size() == 0 ? null : ans.get(ans.size()-1);
            if(ans.size() == 0 || last.end < current.start){
                ans.add(current);
            }
            else last.end = Math.max(last.end, current.end);
        }
        int sum = 0;
       if(ans.size() > 0 && ans.get(0).start > 1){
        sum = ans.get(0).start - 1;
       }
    
        for(int i = 1; i < ans.size(); i++){
           
                sum += ans.get(i).start - ans.get(i-1).end - 1;
                
            
        }
        if(ans.size() > 0 && ans.get(ans.size()-1).end < days){
            sum += days - ans.get(ans.size() - 1).end ;
        }
        return sum;
    }
}