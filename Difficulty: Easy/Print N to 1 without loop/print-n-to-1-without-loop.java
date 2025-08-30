class Solution {

    void printNos(int N) {
        // code here
        if(N == 1){
            System.out.print(N);
            return;
        }
        System.out.print(N);
        System.out.print(" ");
        printNos(N-1);
        
    }
}