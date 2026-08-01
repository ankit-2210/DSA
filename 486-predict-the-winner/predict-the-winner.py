class Solution:
    def solve(self, i, j, nums, dp, n):
        if i>j:
            return 0
        
        if dp[i][j] != -1:
            return dp[i][j]

        first=nums[i]-self.solve(i+1, j, nums, dp, n)
        second=nums[j]-self.solve(i, j-1, nums, dp, n)

        dp[i][j]=max(first, second)
        return dp[i][j]
    
    def predictTheWinner(self, nums: List[int]) -> bool:
        n=len(nums)

        dp=[[-1 for _ in range(n)] for _ in range(n)]
        if self.solve(0, n-1, nums, dp, n)>=0:
            return True

        return False