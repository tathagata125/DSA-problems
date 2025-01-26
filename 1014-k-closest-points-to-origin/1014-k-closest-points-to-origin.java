class Solution {
    class Node implements Comparable<Node>{
        int start ;
        int end;
        public Node(int start, int end){
            this.start = start;
            this.end = end;
        }
        public int compareTo(Node other){
            if(Math.sqrt(this.start*this.start + this.end*this.end) < Math.sqrt(other.start*other.start + other.end*other.end))return 1;
            else if(Math.sqrt(this.start*this.start + this.end*this.end) > Math.sqrt(other.start*other.start + other.end*other.end))return -1;
            else return 0;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        
        for(int i = 0; i < points.length ; i++){
            Node top=null ;
            int s=0 ;
            int e=0 ;
            if(pq.size() != 0){
                top = pq.peek();
                s = top.start;
                 e = top.end;
            }
            if(pq.size() < k){
                pq.add(new Node(points[i][0],points[i][1]));
            }else if(Math.sqrt(s*s + e*e) > Math.sqrt(points[i][0]*points[i][0] + points[i][1]*points[i][1]) ){
                pq.remove();
                pq.add(new Node(points[i][0],points[i][1]));
            }
            
        }
        int[][] arr = new int[k][2];
        for(int i = k-1 ; i>=0 ; i--){
            Node top = pq.remove();
            int s = top.start;
            int e = top.end;
            arr[i][0] = s;
            arr[i][1] = e;
        }
        return arr;
    }
}