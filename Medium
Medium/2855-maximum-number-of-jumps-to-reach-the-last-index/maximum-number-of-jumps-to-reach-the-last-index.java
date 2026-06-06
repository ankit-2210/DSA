class Solution {
    public int maximumJumps(int[] nums, int t){
        int n=nums.length;

        int[] dp=new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0]=0;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(-t<=nums[i]-nums[j] && nums[i]-nums[j]<=t && 1+dp[j]>dp[i]){
                    if(dp[j]>-1){
                        dp[i]=Math.max(dp[i], 1+dp[j]);
                    }
                }
            }
        }

        if(dp[n-1] == Integer.MIN_VALUE)
            return -1;

        return dp[n-1];
    }
}