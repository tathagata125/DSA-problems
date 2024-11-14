class Solution {
public:
    double pow(double x, int n){
        if(n == 0){
            return 1.0;
        }
        double half = pow(x,n/2);
        if(n % 2 == 0){
            
            return half*half;
        }
        else{
            return x*half*half;
        }
    }
    double myPow(double x, int n) {
        long N = n;
        if(N >= 0){
            return pow(x,N);
        }
        else{
            return  1.0/pow(x,-1l*N);
        }
    }
};