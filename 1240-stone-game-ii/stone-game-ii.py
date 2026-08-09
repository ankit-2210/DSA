class Solution:
    def solve(self, idx, m, p, dp, n):
        if idx>=n:
            return 0

        if dp[idx][m] != -1:
            return dp[idx][m]

        t=0
        res=float('-inf')
        for i in range(2*m):
            if idx+i<n:
                t += p[idx+i]

            res=max(res, t-self.solve(idx+i+1, max(m, i+1), p, dp, n))

        dp[idx][m]=res
        return dp[idx][m]
    
    def stoneGameII(self, p: List[int]) -> int:
        n=len(p)

        total=sum(p)
        dp=[[-1]*(101) for _ in range(n+1)]

        diff=self.solve(0, 1, p, dp, n)
        return (total+diff)//2


