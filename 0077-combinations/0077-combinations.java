class Solution {
    List<List<Integer>> com;
    void getAllCom(int n, int k, List<Integer>output,int last){
        if(k == 0){
            com.add(new ArrayList<>(output));
            return;
        }
        
        for(int item = last + 1 ; item <= n ; item++){
            output.add(item);
            getAllCom( n,  k-1, output, item);
            output.remove(output.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        com = new ArrayList<>();
        List<Integer>output = new ArrayList<>();
        getAllCom(n,k,output,0);
        return com;
    }
}