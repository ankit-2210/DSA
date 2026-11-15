class Solution{
    long solve(int idx, int[] nums, long[] dp, int n){
        if(idx>=n)
            return 0;

        if(dp[idx] != Long.MIN_VALUE)
            return dp[idx];

        long sum1=nums[idx];
        long take1;
        if(sum1%3 == 0){
            take1=sum1-solve(idx+1, nums, dp, n);
        }
        else{
            take1=sum1+solve(idx+1, nums, dp, n);
        }

        long take2=Long.MIN_VALUE;
        if(idx+1<n){
            long sum2=nums[idx]+nums[idx+1];
            if(sum2%3 == 0){
                take2=sum2-solve(idx+2, nums, dp, n);
            }
            else{
                take2=sum2+solve(idx+2, nums, dp, n);
            }
        }

        dp[idx]=Math.max(take1, take2);
        return dp[idx];

    }

    public long maxDifference(int[] nums){
        int n=nums.length;

        long[] dp=new long[n];
        Arrays.fill(dp, Long.MIN_VALUE);

        return solve(0, nums, dp, n);
        
    }
}