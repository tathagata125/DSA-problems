class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] arr = new int[A.length+1];
        int[] res = new int[A.length];
        int count = 0;
        for(int i = 0; i < A.length; i++){
            
            if(++arr[A[i]] ==2)count++;
            if( ++arr[B[i]] ==2)count++;
            res[i]=count;    
            
            
        }
        return res;
    }
}