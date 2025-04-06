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
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String findLongestWord(String s, List<String> d) {
        int i = 0; 
        int j = 0;
        int k = 0;
        String result = "";
        while(i < d.size()){
            String str = d.get(i);
            while(j < str.length() && k < s.length()){
                if(str.charAt(j) == s.charAt(k)){
                    j++;
                    k++;
                }
                else{
                    k++;
                }
            }
            if(j == str.length() && result.length() > 0 ){
                if(result.length() < str.length()){
                    result = str;
                }
                else if(result.length() == str.length()){
                    int l = 0;
                    int r = 0;
                    while( l < result.length() && r < str.length()){
                        if(result.charAt(l) < str.charAt(r))break;
                        else if(result.charAt(l) > str.charAt(r)){
                            result = str;
                            break;
                        }
                        else{
                            l++;
                            r++;
                        }
                    }
                }
            }
            else if(j == str.length() && result.length() == 0){
                result = str;
            }
            i++;
            j=0;
            k=0;
        }
        return result;
    }
}