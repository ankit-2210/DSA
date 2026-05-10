class Solution:
    def maximumJumps(self, nums: List[int], t: int) -> int:
        n=len(nums)

        dp=[float("-inf")]*n
        dp[0]=0
        for i in range(1, n):
            for j in range(0, i):
                if -t<=nums[i]-nums[j] and nums[i]-nums[j]<=t and 1+dp[j]>dp[i]:
                    if(dp[j]>-1):
                        dp[i]=max(dp[i], 1+dp[j])
                    
        return -1 if dp[n-1] == float("-inf") else dp[n-1]