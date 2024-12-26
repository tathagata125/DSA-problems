class Solution {
    List<List<Integer>> com;
    void getAllCom(int n, int k, List<Integer>output){
        if(k == 0){
            com.add(new ArrayList<>(output));
            return;
        }
        if( n == 0 || k > n){
            return;
        }
        output.add(n);
        getAllCom( n-1,  k-1, output);
        output.remove(output.size() - 1);
        getAllCom( n-1,  k, output);
    }
    public List<List<Integer>> combine(int n, int k) {
        com = new ArrayList<>();
        List<Integer>output = new ArrayList<>();
        getAllCom(n,k,output);
        return com;
    }
}