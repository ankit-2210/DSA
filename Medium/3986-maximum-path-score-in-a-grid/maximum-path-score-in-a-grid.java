class Solution{
    int solve(int i, int j, int c, int[][] g, int k, int[][][] dp, int n, int m){
        if(i>=n || j>=m)    
            return Integer.MIN_VALUE;

        if(dp[i][j][c] != -1)
            return dp[i][j][c];
            
        int score=0, cost=0;
        if(g[i][j] == 1){
            score += 1;
            cost += 1;
        }
        else if(g[i][j] == 2){
            score += 2;
            cost += 1;
        }

        if(c+cost>k)
            return dp[i][j][c]=Integer.MIN_VALUE;
        if(i == n-1 && j == m-1)
            return dp[i][j][c]=score;

        int right=solve(i, j+1, c+cost, g, k, dp, n, m);
        int down=solve(i+1, j, c+cost, g, k, dp, n, m);
        int mxscore=Math.max(right, down);
        if(mxscore == Integer.MIN_VALUE)
            return dp[i][j][c]=Integer.MIN_VALUE;
        dp[i][j][c]=mxscore+score;
        return dp[i][j][c];
    }

    public int maxPathScore(int[][] g, int k){
        int n=g.length;
        int m=g[0].length;

        int[][][] dp=new int[n+1][m+1][k+1];
        for(int i=0; i<=n; i++){
            for(int j=0; j<=m; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }

        int t=solve(0, 0, 0, g, k, dp, n, m);
        if(t == Integer.MIN_VALUE)
            return -1;
        return t;
    }
}