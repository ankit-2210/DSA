class Solution:
    def solve(self, idx, arr, d, dp, n):
        if idx<0 or idx>=n:
            return 0

        if dp[idx] != -1:
            return dp[idx]

        res=1
        for i in range(idx+1, min(idx+d+1, n)):
            if arr[i]>=arr[idx]:
                break
            res=max(res, 1+self.solve(i, arr, d, dp, n))

        for i in range(idx-1, max(-1, idx-d-1), -1):     
            if arr[i]>=arr[idx]:
                break
            res=max(res, 1+self.solve(i, arr, d, dp, n))

        dp[idx]=res
        return dp[idx]
    
    def maxJumps(self, arr: List[int], d: int) -> int:
        n=len(arr);

        dp=[-1]*n
        res=1
        for i in range(n):
            res=max(res, self.solve(i, arr, d, dp, n))

        return res