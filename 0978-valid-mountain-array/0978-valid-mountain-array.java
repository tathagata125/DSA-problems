class Solution {
    public boolean validMountainArray(int[] arr) {
        if(arr.length <3) return false;
        if(arr[0]< arr[1]){
            int i ;
            for( i = 0; i<arr.length-1; i++){
                if(arr[i] > arr[i+1]){
                    break;
                }
                if(arr[i] == arr[i+1]){
                    return false;
                }
            }
            if(i == arr.length - 1){
                return false;
            }
            for(; i<arr.length-1; i++){
                if(arr[i] <= arr[i+1]){
                    return false;
                }
            }
        }
        else {
            return false;
        }
        
        return true;
    }
        
    };
    
