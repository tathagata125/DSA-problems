class Solution {
    class Node implements Comparable<Node>{
        int start ;
        int end;
        public Node(int start, int end){
            this.start = start;
            this.end= end;
        }
        public int compareTo(Node other){
            if(this.start <= other.start)return -1;
            else{
                return +1;
            }
        }

    }
    public int[][] merge(int[][] intervals) {
        PriorityQueue<Node>pq = new PriorityQueue<>();
        for(int i =0; i<intervals.length; i++){
            pq.add(new Node(intervals[i][0],intervals[i][1]));
        }
        ArrayList<ArrayList<Integer>>arr = new ArrayList<>();
        while(pq.size() > 0){
                Node root = pq.remove();
                int start = root.start;
                int end = root.end;
            if(arr.size() == 0){
                
                ArrayList<Integer>output = new ArrayList<>();
                output.add(start);
                output.add(end);
                arr.add(output);
            }
            else{
                
                if(arr.get(arr.size()-1).get(1) >= start ){
                    if(arr.get(arr.size()-1).get(1) < end){
                        arr.get(arr.size()-1).set(1,end);
                    }
                }else{
                    ArrayList<Integer>output = new ArrayList<>();
                    output.add(start);
                     output.add(end);
                    arr.add(output);
                }
            }
        }
        int[][] ar = new int[arr.size()][arr.get(0).size()];
        for(int i = 0; i<arr.size(); i++){
            ar[i][0]=arr.get(i).get(0);
            ar[i][1]=arr.get(i).get(1);
        }
        return ar;
    }
}