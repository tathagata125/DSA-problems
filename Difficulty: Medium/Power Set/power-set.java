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
{   List<String>res;
    public void powerSet(String s,String  out, int idx){
        if(idx == s.length()){
            res.add(out);
            return;
        }
        powerSet(s,out+s.charAt(idx),idx+1);
        powerSet(s,out,idx+1);
    }
    public List<String> AllPossibleStrings(String s)
    {   
        res = new ArrayList<>();
        powerSet(s,"",0);
        Collections.sort(res);
        return res;
        
    }
}