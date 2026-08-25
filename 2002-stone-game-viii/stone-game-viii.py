class Solution:
    def stoneGameVIII(self, s: List[int]) -> int:
        n=len(s)

        prefix=[0]*n
        prefix[0]=s[0]
        for i in range(1, n):
            prefix[i]=prefix[i-1]+s[i]

        res=prefix[n-1]
        i=n-2
        while i>=1:
            res=max(res, prefix[i]-res)
            i-=1

        return res