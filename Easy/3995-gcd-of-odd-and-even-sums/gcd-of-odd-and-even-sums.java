class Solution{
    public int solve(int a, int b){
        if(b == 0)
            return a;
        return solve(b, a%b);
    }

    public int gcdOfOddEvenSums(int n){
        int odd=(n*n);
        int even=n*(n+1);

        return solve(odd, even);

    }
}