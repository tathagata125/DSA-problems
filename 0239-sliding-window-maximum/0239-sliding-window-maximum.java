class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            while(q.size() > 0 && nums[q.getLast()] < nums[i]){
                q.removeLast();
            }
            q.addLast(i);

            if((i-q.getFirst())+1 > k){
                q.removeFirst();
            }
            if(i >= k-1)
            res.add(q.getFirst());
        }
        int[] arr = new int[res.size()];
        for(int i= 0; i<res.size(); i++){
            arr[i]=nums[res.get(i)];
        }
        return arr;
    }
}