class Solution:
    def solve(self, g, n):
        lps=[0]*n
        i=1
        len=0
        while i<n:
            if g[i] == g[len]:
                len+=1
                lps[i]=len
                i+=1
            else:
                if(len != 0):
                    len=lps[len-1]
                else:
                    lps[i]=0
                    i+=1
        return lps

    def rotateString(self, s: str, g: str) -> bool:
        if len(s) != len(g):
            return False

        t=s+s
        lps=self.solve(g, len(g))
        i=j=0
        while i<len(t):
            if t[i] == g[j]:
                i+=1
                j+=1
            if j == len(g):
                return True
            elif i<len(t) and t[i] != g[j]:
                if j != 0:
                    j=lps[j-1]
                else:
                    i+=1
            
        return False


        