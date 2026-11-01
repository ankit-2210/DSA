class Solution:
    def minMoves(self, nums: list[int]) -> int:
        n=len(nums)

        nums.sort()
        res=0
        for i in range(1, n):
            res += (nums[i]-nums[0])
        
        return res