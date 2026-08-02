class Solution:
    def solve(self, i, j, p, dp, n):
        if i>j:
            return 0

        if dp[i][j] != -1:
            return dp[i][j]
        
        left=p[i]-self.solve(i+1, j, p, dp, n)
        right=p[j]-self.solve(i, j-1, p, dp, n)

        dp[i][j]=max(left, right)
        return dp[i][j]

    def stoneGame(self, p: List[int]) -> bool:
        n=len(p)

        dp=[[-1]*n for _ in range(n)]
        return self.solve(0, n-1, p, dp, n)>=0
