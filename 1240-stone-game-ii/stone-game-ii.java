class Solution{
    int solve(int idx, int m, int[] p, int[][] dp, int n){
        if(idx>=n)
            return 0;

        if(dp[idx][m] != -1)
            return dp[idx][m];

        int t=0;
        int res=Integer.MIN_VALUE;
        for(int i=0; i<2*m; i++){
            if(idx+i<n){
                t += p[idx+i];
            }

            res=Math.max(res, t-solve(idx+i+1, Math.max(m, i+1), p, dp, n));
        }

        dp[idx][m]=res;
        return dp[idx][m];
    }

    public int stoneGameII(int[] p){
        int n=p.length;

        int sum=Arrays.stream(p).sum();
        System.out.println(sum);

        int[][] dp=new int[n+1][101];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        int diff=solve(0, 1, p, dp, n);
        return (sum+diff)/2;
    }
}