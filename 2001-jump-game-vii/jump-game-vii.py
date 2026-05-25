class Solution:
    def solve(self, idx, s, mn, mx, dp, n):
        if idx>=n or s[idx] == '1':
            return False

        if idx == n-1:
            return True

        if dp[idx] != -1:
            return dp[idx]

        dp[idx]=False
        for i in range(mn, mx+1):
            if self.solve(idx+i, s, mn, mx, dp, n):
                dp[idx]=True
                return True
    
        return dp[idx]

    def canReach(self, s: str, mn: int, mx: int) -> bool:
        n=len(s)
        if s[0] == '1' or s[n-1] == '1':
            return False
        c=0
        for ch in s:
            if ch == '1':
                c+=1
                if c>=mx:
                    return False
            else:
                c=0

        dp=[-1]*n
        return self.solve(0, s, mn, mx, dp, n)


        