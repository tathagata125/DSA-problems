class Solution {
    public int compress(char[] chars) {
        
        int right = 0;
        int write = 0;
        
        while(right < chars.length){
            char current = chars[right];
            int count = 0;
            while( right < chars.length && current == chars[right]){
                right++;
                count++;
            }
            chars[write++]=current;
            if(count > 1){
            for(char c : String.valueOf(count).toCharArray()){
                chars[write++]=c; 
            }
        }
            
    }
        return write;
}
}