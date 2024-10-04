//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().split(" ");
            List<String> d = new ArrayList<String>();
            for (int i = 0; i < n; i++) d.add(input_line[i]);

            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.findLongestWord(S, d));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String findLongestWord(String S, List<String> d) {
        int maxi = Integer.MIN_VALUE;
        String ss="" ;
        for(int i =0; i<d.size();i++){
            String str = d.get(i);
            int j=0; 
            int k=0;
            while(j<S.length() && k<str.length()){
                if(str.charAt(k) == S.charAt(j)){
                    j++;
                    k++;
                }
                else{
                    j++;
                }
            }
            if(k>maxi && k==str.length()){
                ss=str;
                maxi = str.length();
            }
            else if(maxi == k && k==str.length()){
                int l =0;
                for(;l<ss.length();l++){
                    if(ss.charAt(l) > str.charAt(l)){
                        ss = str;
                        maxi = str.length();
                        break;
                    }
                    else if(ss.charAt(l) < str.charAt(l)){
                        break;
                    }
                }
            }
        }
        return ss;
    }
}