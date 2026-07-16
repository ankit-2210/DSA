class Solution:
    def solve(self, a, b):
        if b == 0:
            return a
        return self.solve(b, a%b)
    
    def gcdSum(self, nums: list[int]) -> int:
        n=len(nums)

        res=[0]*n
        res[0]=nums[0]
        mx=nums[0]
        for i in range(1, n):
            mx=max(mx, nums[i])
            res[i]=self.solve(nums[i], mx)

        res.sort()
        sum=0
        i, j = 0, n-1
        while i<j:
            sum += self.solve(res[i], res[j])
            i += 1
            j -= 1

        return sum

