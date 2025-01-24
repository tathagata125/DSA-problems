//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            int N = S.length();
            Solution ob = new Solution();
            String[] element = br.readLine().trim().split("\\s+");
		    int[] f = new int[N];
		    for(int i = 0; i < N; i++){
		        f[i] = Integer.parseInt(element[i]);
		    }
            ArrayList<String> res  = ob.huffmanCodes(S,f,N);
            for(int i = 0; i < res.size(); i++)
            {
                System.out.print(res.get(i)+" ");
            }
            System.out.println();
        
System.out.println("~");
}
	}
}
// } Driver Code Ends

 
//User function Template for Java

class Node implements Comparable<Node>{
    char ch = '#';
    int freq ;
    Node left;
    Node right;
    public Node(char ch , int freq){
        this.ch = ch;
        this.freq = freq;
    }
    public Node(){
        
    }
    
    public int compareTo(Node other){
        if(this.freq < other.freq) return -1;
        return 1;
    }
    
}
class Solution {
    public void preorder(ArrayList<String>res,Node root, String s){
        if(root.ch != '#'){
            res.add(s);
            return;
        }
        
            preorder(res,root.left,s+"0");
            preorder(res,root.right,s+"1");
        
        
    }
    public ArrayList<String> huffmanCodes(String S, int f[], int N)
    {
        PriorityQueue<Node>pq = new PriorityQueue<>();
        for(int i = 0; i<N; i++)pq.add(new Node(S.charAt(i),f[i]));
        while(pq.size() > 1){
            Node root = new Node();
            root.left = pq.remove();
            root.right = pq.remove();
            root.freq = root.left.freq + root.right.freq;
            pq.add(root);
        }
        Node root = pq.remove();
        ArrayList<String> res = new ArrayList<>();
        preorder(res,root,"");
        return res;
        
    }
    
}