class Solution:
    def earliestFinishTime(self, ls: List[int], ld: List[int], ws: List[int], wd: List[int]) -> int:
        n=len(ls)
        m=len(ws)

        first=float('inf')
        for i in range(n):
            first=min(first, ls[i]+ld[i])

        res=float('inf')
        for i in range(m):
            res=min(res, wd[i]+max(first, ws[i]))

        first=float('inf')
        for i in range(m):
            first=min(first, ws[i]+wd[i])
        for i in range(n):
            res=min(res, ld[i]+max(first, ls[i]))

        return res
        