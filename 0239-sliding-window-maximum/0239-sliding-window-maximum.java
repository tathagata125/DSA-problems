class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        ArrayList<Integer> arr = new ArrayList<>();
        

        for(int i =0; i<nums.length ; i++){
            if(q.size() != 0 && nums[q.getLast()] < nums[i]){
                while(q.size() != 0 && nums[q.getLast()] < nums[i]){
                    q.removeLast();
                }
                q.addLast(i);
            }
            else{
                q.addLast(i);
            }
            if((i - q.getFirst() + 1) > k){
                q.removeFirst();
            }
           if(i >= k-1){
            arr.add(nums[q.getFirst()]);
           }
        }
        int[] temp= new int[arr.size()];
        for(int i =0; i<arr.size(); i++){
            temp[i] = arr.get(i);
        }
        return temp;
    }
}