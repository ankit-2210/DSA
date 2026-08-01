class Solution{
    int solve(int i, int j, int[] nums, int[][] dp, int n){
        if(i>j)
            return 0;
        
        if(dp[i][j] != -1)
            return dp[i][j];

        dp[i][j]=Math.max(nums[i]-solve(i+1, j, nums, dp, n), nums[j]-solve(i, j-1, nums, dp, n));
        return dp[i][j];
    }

    public boolean predictTheWinner(int[] nums){
        int n=nums.length;

        int[][] dp=new int[n+1][n+1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }

        if(solve(0, n-1, nums, dp, n)>=0)
            return true;

        return false;
    }
}