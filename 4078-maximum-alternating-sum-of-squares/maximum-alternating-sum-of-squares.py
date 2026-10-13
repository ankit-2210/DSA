class Solution:
    def maxAlternatingSum(self, nums: List[int]) -> int:
        n=len(nums)

        for i in range(n):
            nums[i]=abs(nums[i])

        nums.sort()
        res=0
        for i in range(n//2):
            res += (nums[n-1-i]*nums[n-1-i]-nums[i]*nums[i])

        if n%2 != 0:
            res += (nums[n//2]*nums[n//2])
        
        return res

