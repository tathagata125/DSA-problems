class Solution {
    double pow(double x, long n){
        if(n == 0)return 1.0;
        if(n%2 == 1) 
        return pow(x, n-1)*x;
        double p= pow(x,n/2);
        return p*p;
    }
    public double myPow(double x, int n) {
        long ln = n;
        if(n >= 0)
        return pow(x,ln);
        
        return pow(1/x,-ln);

    }
}