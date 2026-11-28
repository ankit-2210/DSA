class Solution{
    int solve(int idx, int b, int mn, int[][] it, int[][] dp, int[] copies, int n){
        if(idx>=n || b<=0)
            return b/mn;

        if(dp[idx][b] != -1)
            return dp[idx][b];

        int take=0;
        int price=it[idx][1];

        if(price<=b){
            take=1+copies[idx]+solve(idx+1, b-price, mn, it, dp, copies, n);
        }
        int skip=solve(idx+1, b, mn, it, dp, copies, n);

        return dp[idx][b]=Math.max(take, skip);
    }

    public int maximumSaleItems(int[][] it, int b){
        int n=it.length;

        int[] copies=new int[n];

        int mn=Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            mn=Math.min(mn, it[i][1]);

            int copy=0;
            for(int j=0; j<n; j++){
                if(i == j)
                    continue;
                
                if(it[j][0]%it[i][0] == 0){
                    copy++;
                }
            }

            copies[i]=copy;
        }

        int[][] dp=new int[n+1][b+1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        return solve(0, b, mn, it, dp, copies, n);

    }
}