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
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        
System.out.println("~");
}
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        List<String> result = getSubsequences(s,0);
        Collections.sort(result);
        result.remove(0);
        return result;
    }
    public List<String> getSubsequences(String s, int idx){
        if(idx == s.length()){
            List<String> result = new ArrayList<>();
            result.add("");
            return result;
        }
        List<String>r = getSubsequences(s,idx + 1);
        int n = r.size();
        for(int  i = 0; i<n; i++){
            String ses = s.charAt(idx) + r.get(i);
            r.add(ses);
        }
        return r;
    }
    
}