// User function Template for Java

class GFG {
    ArrayList<Integer> fin(int arr[], int idx, int x){
        if(idx == arr.length){
            ArrayList<Integer>base = new ArrayList<>();
            base.add(-1);
            base.add(-1);
            return base;
        }
        ArrayList<Integer> res = fin(arr, idx + 1, x);
        if(arr[idx] == x){
            if(res.get(0) == -1) {res.set(1,idx); res.set(0,idx); }
            else res.set(0,idx);
        }
        return res;
    }
    ArrayList<Integer> find(int arr[], int x) {
        // code here
        ArrayList<Integer> ar = fin(arr , 0 , x);
        return ar;
        
    }
}
