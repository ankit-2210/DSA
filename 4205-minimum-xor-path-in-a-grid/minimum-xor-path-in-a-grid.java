class Solution{
    int solve(int i, int j, int x, int[][] g, int[][][] dp, int n, int m){
        if(i<0 || i>=n || j<0 || j>=m)
            return Integer.MAX_VALUE;

        x ^= g[i][j];
        if(i == n-1 && j == m-1)
            return x;
            
        if(dp[i][j][x] != -1)
            return dp[i][j][x];

        int right=solve(i, j+1, x, g, dp, n, m);
        int down=solve(i+1, j, x, g, dp, n, m);

        dp[i][j][x]=Math.min(right, down);
        return dp[i][j][x];
    }

    public int minCost(int[][] g){
        int n=g.length;
        int m=g[0].length;

        int[][][] dp=new int[n][m][1024];
        for(int[][] row: dp){
            for(int[] col: row){
                Arrays.fill(col, -1);
            }
        }

        return solve(0, 0, 0, g, dp, n, m);

    }
}