//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends



class Solution {
    // Function to find the minimum number of swaps required to sort the array.
    class Graph{
        int n;
        ArrayList<Integer>[] adj;
        Graph(int n){
            this.n = n;
            adj = new ArrayList[n];
            for(int i = 0; i < n; i++){
                adj[i]=new ArrayList<>();
            }
        }
        void addEdge(int src, int dest){
            adj[src].add(dest);
        
        }
        int dfs(int src, int[] vis){
            if(vis[src] == 1)return 0;
            vis[src] = 1;
            int size = 1;
            for(int n : adj[src]){
               size += dfs(n,vis);
            }
            return size;
        }
    }
    public int minSwaps(int arr[]) {
        HashMap<Integer,Integer> m = new HashMap<>();
        for(int i = 0; i<arr.length; i++){
            m.put(arr[i],i);
        }
        Arrays.sort(arr);
        Graph g = new Graph(arr.length);
        for(int i = 0; i < arr.length; i++){
            g.addEdge(i,m.get(arr[i]));
        }
        int connected= 0;
        int[] vis = new int[arr.length];
        int swap = 0;
        for(int i =0; i < arr.length; i++){
            connected++;
            if(vis[i] != 1){
               int size = g.dfs(i,vis);
                swap += (size-1);
            }
        }
        return swap;
    }
}


//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int ans = obj.minSwaps(arr);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends