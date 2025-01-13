class Solution {
    public int minimumLength(String s) {
        int[] arr = new int[256];
        for(char ch : s.toCharArray()){
            int idx = ch - 'a';
            arr[idx]+=1;
        }
        int count = 0;
        for(int i = 0; i<s.length(); i++){
            int idx = s.charAt(i) - 'a';
            int freq = arr[idx];
            if(freq == 0)continue;
            if(freq%2 == 0)
                count+=2;
            else
                count+=1;
            arr[idx] = 0;
        }
        return count;
    }
}