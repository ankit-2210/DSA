class Solution{
    int solve(int idx, int n, int[] c, int[] dp, int m){
        if(idx>n)
            return Integer.MAX_VALUE;

        if(idx == n)
            return 0;

        if(dp[idx] != -1)
            return dp[idx];

        int ones=(1+c[idx])+solve(idx+1, n, c, dp, m);
        int twos=(idx+2<=n)?(4+c[idx+1])+solve(idx+2, n, c, dp, m):Integer.MAX_VALUE;
        int threes=(idx+3<=n)?(9+c[idx+2])+solve(idx+3, n, c, dp, m):Integer.MAX_VALUE;
        
        dp[idx]=Math.min(ones, Math.min(twos, threes));
        return dp[idx];
    }

    public int climbStairs(int n, int[] c){
        int m=c.length;

        int[] dp=new int[n+1];
        Arrays.fill(dp, -1);
        return solve(0, n, c, dp, m);

    }
}