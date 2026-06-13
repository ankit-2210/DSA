class Solution:
    def solve(self, s, wt, m):
        res=0
        for i in range(0, len(s)):
            res += wt[ord(s[i])-ord('a')]
        
        return res
    
    def mapWordWeights(self, w: List[str], wt: List[int]) -> str:
        n=len(w)
        m=len(wt)

        str=[]
        for i in range(n):
            s=w[i]

            t=self.solve(s, wt, m)
            str.append(chr(ord('z')-(t%26)))

        return "".join(str)