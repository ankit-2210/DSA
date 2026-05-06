class Solution:
    def rotateTheBox(self, b: List[List[str]]) -> List[List[str]]:
        n=len(b)
        m=len(b[0])

        dp=[['.' for _ in range(n)] for _ in range(m)]
        for r in range(n):
            i=m-1
            for c in range(m-1, -1, -1):
                if b[r][c] == '#':
                    dp[i][n-r-1]='#'
                    i-=1
                elif b[r][c] == '*':
                    dp[c][n-r-1]='*'
                    i=c-1

        return dp
        