class Solution {
    public boolean checkIfPangram(String sentence) {
       int[] arr = new int[26];
       int count = 0;
       for(int i = 0; i < sentence.length(); i++){
            if(arr[sentence.charAt(i) - 'a'] == 1){
                continue;
            }
            arr[sentence.charAt(i)-'a']++;
            count++;
       }
       return count==26; 
    }
}