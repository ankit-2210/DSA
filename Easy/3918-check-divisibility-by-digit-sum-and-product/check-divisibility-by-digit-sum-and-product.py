class Solution:
    def solve(self, n):
        temp=n
        s=0
        prod=1

        while n>0:
            rem=n%10
            n//=10
            s += rem
            prod *= rem

        total=s+prod
        if temp%total == 0:
            return True
        
        return False
    
    def checkDivisibility(self, n: int) -> bool:
        return self.solve(n)

