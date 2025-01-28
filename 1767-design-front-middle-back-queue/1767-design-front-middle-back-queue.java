class FrontMiddleBackQueue {
    Deque<Integer> front = new ArrayDeque<>();
    Deque<Integer> end = new ArrayDeque<>();
    public FrontMiddleBackQueue() {
        
    }
    
    public void pushFront(int val) {
        front.addFirst(val);
        while(front.size() > end.size() && (front.size() - end.size()) >= 2){
            int el = front.removeLast();
            end.addFirst(el);
        }
    }
    
    public void pushMiddle(int val) {
        if(front.size() == end.size())front.addLast(val);
        else{
            int e = front.removeLast();
            front.addLast(val);
            end.addFirst(e);
        }
        while(front.size() > end.size() && (front.size() - end.size()) >= 2){
            int ele = front.removeLast();
            end.addFirst(ele);
        }
    }
    
    public void pushBack(int val) {
        end.addLast(val);
        while(front.size() < end.size()){
            int ele = end.removeFirst();
            front.addLast(ele);
        }

    }
    
    public int popFront() {
        if(front.size() == 0)return -1;
        int el = front.removeFirst();
        while(end.size() != 0 && front.size() < end.size()){
            int ele = end.removeFirst();
            front.addLast(ele);
        }
        return el;
    }
    
    public int popMiddle() {
        if(front.size() == 0)return -1;
        int el = front.removeLast();
        while(end.size() != 0 && front.size() < end.size()){
            int ele = end.removeFirst();
            front.addLast(ele);
        }
        return el;
    }
    
    public int popBack() {
        if(front.size() == 0 && end.size()==0)return -1;
        if(end.size() == 0)return front.removeLast();
        int el = end.removeLast();
        while(front.size() != 0 && (front.size() - end.size()) >= 2){
         int ele = front.removeLast();
            end.addFirst(ele);   
        }
        return el;
    }
}

/**
 * Your FrontMiddleBackQueue object will be instantiated and called as such:
 * FrontMiddleBackQueue obj = new FrontMiddleBackQueue();
 * obj.pushFront(val);
 * obj.pushMiddle(val);
 * obj.pushBack(val);
 * int param_4 = obj.popFront();
 * int param_5 = obj.popMiddle();
 * int param_6 = obj.popBack();
 */