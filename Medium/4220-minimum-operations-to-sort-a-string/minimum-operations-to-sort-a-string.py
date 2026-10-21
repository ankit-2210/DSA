class Solution:
    def solve(self, s):
        for i in range(len(s)-1):
            if s[i]>s[i+1]:
                return False

        return True
    
    def minOperations(self, s: str) -> int:
        n=len(s)

        if self.solve(s):
            return 0
    
        if n == 2 and self.solve(s) == False:
            return -1

        lidx, hidx=-1, -1
        lch='z'
        rch='a'
        for i in range(n):
            if s[i]>=rch:
                rch=s[i]
                hidx=i
            if s[i]<lch:
                lch=s[i]
                lidx=i

        if lidx == 0 or hidx == n-1:
            return 1
        if lidx == n-1 and hidx == 0:
            return 3

        return 2