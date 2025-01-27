//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0)
        {
            int N = sc.nextInt();
            int arr[] = new int[N];
            for(int i=0; i<N; i++)
                arr[i] = sc.nextInt();
            
            Solution g = new Solution();
            long ans = g.wineSelling(arr,N);
            
            System.out.println(ans);
            T--;
        
System.out.println("~");
}
    }
}


// } Driver Code Ends
//User function Template for Java


class Solution {
    long wineSelling(int Arr[],int N){
        int[] seller= new int[Arr.length];
        int[] buyer = new int[Arr.length];
        for(int i = 0; i < N; i++){
            if(Arr[i] < 0){
                seller[i]=-Arr[i];
            }
            else{
                buyer[i] = Arr[i];
            }
        }
        int s = 0;
        int b = 0;
        long work = 0;
        while(s < N && b < N){
        
                while(s<N && seller[s] == 0 )
                    s++;
                
            
                while(b<N  && buyer[b] == 0)
                    b++;
                if(b ==N || s == N)break;
                if((seller[s] - buyer[b]) < 0 ){
                    work += ( seller[s])*Math.abs(s-b);
                    
                    buyer[b] = buyer[b] - seller[s];
                    seller[s]=0;
                }
                else if((seller[s] - buyer[b]) > 0){
                    work += ( buyer[b])*Math.abs(s-b);
                   
                    seller[s] = seller[s]-buyer[b];
                     buyer[b]=0;
                }
                else{
                    work+= buyer[b]*Math.abs(s-b);
                    buyer[b]=0;
                    seller[s]=0;
                }
            
        }
        return work;
        
    }
}

//{ Driver Code Starts.
// } Driver Code Ends