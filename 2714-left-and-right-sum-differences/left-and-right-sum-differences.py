class Solution:
    def leftRightDifference(self, nums: List[int]) -> List[int]:
        n=len(nums)

        leftsum=[0]*n
        rightsum=[0]*n
        for i in range(1, n):
            leftsum[i]=leftsum[i-1]+nums[i-1]
        for i in range(n-2, -1, -1):
            rightsum[i]=rightsum[i+1]+nums[i+1]

        res=[0]*n
        for i in range(n):
            res[i]=abs(leftsum[i]-rightsum[i])

        return res