class Solution{
    static final int mod=1000000007;
    long solve(int i, int j, int dir, long[][][] dp, int[][] g, int n, int m){
        if(i>=n || j>=m)
            return 0;

        if(i == n-1 && j == m-1)
            return 1;

        if(dp[i][j][dir] != -1)
            return dp[i][j][dir];

        long res;
        if(g[i][j] == 1){
            if(dir == 0){
                res=solve(i+1, j, 1, dp, g, n, m)%mod;
            }
            else{
                res=solve(i, j+1, 0, dp, g, n, m)%mod;
            }
        }
        else{
            res=(solve(i, j+1, 0, dp, g, n, m)+solve(i+1, j, 1, dp, g, n, m))%mod;
        }   

        dp[i][j][dir]=res;
        return dp[i][j][dir];
    }

    public int uniquePaths(int[][] g){
        int n=g.length;
        int m=g[0].length;

        long[][][] dp=new long[n][m][2];
        for(long[][] row: dp){
            for(long[] col: row){
                Arrays.fill(col, -1);
            }
        }

        return (int)solve(0, 0, 0, dp, g, n, m);

    }
}