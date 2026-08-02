class Solution{
    int solve(int i, int j, int[] p, int[][] dp, int n){
        if(i>j)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        int left=p[i]-solve(i+1, j, p, dp, n);
        int right=p[j]-solve(i, j-1, p, dp, n);

        dp[i][j]=Math.max(left, right);
        return dp[i][j];
    }

    public boolean stoneGame(int[] p){
        int n=p.length;

        int[][] dp=new int[n][n];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        if(solve(0, n-1, p, dp, n)>=0)
            return true;

        return false;
    }
}