class Solution {
    
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings , (t,o) ->{
            if(t[0] < o[0]) return -1;
            else if(t[0] > o[0])return 1;
            else return 0;
        }
        );
        
        List<int[]> ans = new ArrayList<>();
        for(int[] current : meetings){
           
            int[] last = ans.size() == 0 ? null : ans.get(ans.size()-1);
            if(ans.size() == 0 || last[1] < current[0]){
                ans.add(current);
            }
            else last[1] = Math.max(last[1], current[1]);
        }
        int sum = 0;
       if(ans.size() > 0 && ans.get(0)[0] > 1){
        sum = ans.get(0)[0] - 1;
       }
    
        for(int i = 1; i < ans.size(); i++){
           
                sum += ans.get(i)[0] - ans.get(i-1)[1] - 1;
                
            
        }
        if(ans.size() > 0 && ans.get(ans.size()-1)[1] < days){
            sum += days - ans.get(ans.size() - 1)[1] ;
        }
        return sum;
    }
}