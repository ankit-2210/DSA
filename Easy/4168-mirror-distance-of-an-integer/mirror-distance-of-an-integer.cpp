class Solution{
public:
    int solve(int n){
        int r=0;
        while(n>0){
            int rem=n%10;
            n/=10;
            r=r*10+rem;
        }

        return r;
    }

    int mirrorDistance(int n){
        int rev=solve(n);
        return abs(n-rev);

    }
};