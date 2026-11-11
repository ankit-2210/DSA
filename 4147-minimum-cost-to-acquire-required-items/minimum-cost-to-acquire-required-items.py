class Solution:
    def minimumCost(self, c1: int, c2: int, cb: int, n1: int, n2: int) -> int:
        
        k=c1*n1 + c2*n2
        l=min(n1, n2)*cb
        m=max(n1, n2)*cb

        n=0
        if n1>n2:
            n=abs(n1-n2)*c1
        else:
            n=abs(n2-n1)*c2

        return min(k, min(l+n, m))