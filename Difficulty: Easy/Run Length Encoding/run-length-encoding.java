//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s;
            s = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.encode(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String encode(String s) {
        StringBuilder str = new StringBuilder();
        int left = 0;
        int right =0;
        str.append(s.charAt(left));
        while(right < s.length()){
            if(s.charAt(left) == s.charAt(right)){
                right++;
            }
            else{
                str.append(right - left);
                left = right;
                str.append(s.charAt(left));
            }
        }
        str.append(right-left);
        return str.toString();
    }
}
    