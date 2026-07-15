class Solution:
    def solve(self, a, b):
        if b == 0:
            return a
        return self.solve(b, a%b)
    
    def gcdOfOddEvenSums(self, n: int) -> int:
        odd=n*n
        even=n*(n+1)

        return self.solve(odd, even)