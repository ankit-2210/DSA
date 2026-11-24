class Solution:
    def solve(self, a, b):
        if b == 0:
            return a
        
        return self.solve(b, a%b)
    
    def maxLength(self, nums: List[int]) -> int:
        n=len(nums)

        res=2
        prod=1
        i, j=0, 0
        while j<n:
            x=nums[j]
            while self.solve(prod, x)>1:
                prod //= nums[i]
                i+=1

            prod *= x
            res=max(res, j-i+1)
            j+=1

        return res