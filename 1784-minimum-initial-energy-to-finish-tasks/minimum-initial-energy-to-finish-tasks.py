class Solution:
    def minimumEffort(self, t: List[List[int]]) -> int:
        n=len(t)

        t.sort(key=lambda x:(x[1]-x[0]), reverse=True)
        res=0
        curr=0
        for ac, mn in t:
            if curr<mn:
                res += (mn-curr)
                curr=mn
            curr -= ac

        return res