class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
       int start = 0;
        int deficit =0;
        int fuel =0;
        int sstart = 0;
        for(int i =0 ; i<gas.length; i++){
            fuel +=gas[i];
            if(fuel < cost[i]){
                start = i+1; 
                deficit += cost[i] - fuel;
                fuel = 0;
                continue;
            }
            fuel = fuel - cost[i];
       }
       if(fuel >= deficit){return start;}
       return -1;
    }
}