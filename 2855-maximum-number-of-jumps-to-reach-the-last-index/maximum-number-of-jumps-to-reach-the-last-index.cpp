class Solution{
public:
    int maximumJumps(vector<int> &nums, int t){
        int n=nums.size();

        vector<int> dp(n, INT_MIN);
        dp[0]=0;
        for(int i=1; i<n; i++){
            for(int j=0; j<i; j++){
                if(-t<=nums[i]-nums[j] && nums[i]-nums[j]<=t && 1+dp[j]>dp[i]){
                    if(dp[j]>-1){
                        dp[i]=max(dp[i], 1+dp[j]);
                    }
                }
            }
        }

        if(dp[n-1] == INT_MIN)
            return -1;

        return dp[n-1];
    }
};