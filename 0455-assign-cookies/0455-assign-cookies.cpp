class Solution {
public:
    int findContentChildren(vector<int>& g, vector<int>& s) {
        priority_queue<int>p;
        priority_queue<int>c;
        int count =0;
        for(int i =0 ;i<s.size();i++){
            p.push(s[i]);
        }
        for(int i =0 ;i<g.size();i++){
            c.push(g[i]);
        }
        while(p.size() != 0 && c.size()!= 0){
            if(c.top() <= p.top()){
                c.pop();
                p.pop();
                count++;
        }
        else{
            c.pop();
        }
    }
    return count;
    }
};