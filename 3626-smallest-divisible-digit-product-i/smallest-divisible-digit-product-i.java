class Solution{
    int solve(int n){
        int res=1;
        while(n>0){
            int rem=n%10;
            n/=10;
            res *= rem;
        }

        return res;
    }

    public int smallestNumber(int n, int t){
        
        while(solve(n)%t != 0){
            n++;
        }

        return n;


    }
}