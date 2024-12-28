class Solution {
    List<List<Integer>>coin ;
    void combinations(int[] candidates, List<Integer>output, int target, int sum, int i){
        if(target == sum){
            if(!coin.contains(output)){
            coin.add(new ArrayList<>(output));
            return;
        }
        }
        if(sum > target || i == candidates.length){
            return;
        }
        
            sum +=candidates[i];
            output.add(candidates[i]);
            combinations(candidates, output,  target, sum, i);
            
            output.remove(output.size() - 1);
            
            sum -=candidates[i];
            
            combinations(candidates, output,  target, sum,i+1);
            
        
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        coin = new ArrayList<>();
        Arrays.sort(candidates);
        List<Integer>output = new ArrayList<>();
        combinations(candidates,output,target,0,0);
        return coin;
    }
}