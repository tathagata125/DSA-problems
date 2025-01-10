class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayList<Integer> stack = new ArrayList<>();
        int idx =0;
        while(idx < asteroids.length){
            if(asteroids[idx]> 0){
                stack.add(asteroids[idx]);
            }
            else{
                if(stack.size() == 0 || stack.get(stack.size() - 1) < 0){
                    stack.add(asteroids[idx]);
                }
                else if(stack.get(stack.size() - 1) < -asteroids[idx]){
                    stack.remove(stack.size() - 1);
                    idx--;
                }
                else if(stack.get(stack.size()-1) == -asteroids[idx]){
                    stack.remove(stack.size() - 1);
                }
                
            }
            idx++;
            

        }
        int[] temp = new int[stack.size()];
        int i =0;
        while(i < stack.size()){
            temp[i] = stack.get(i);
            i++;
        }
        return temp;
    }
}