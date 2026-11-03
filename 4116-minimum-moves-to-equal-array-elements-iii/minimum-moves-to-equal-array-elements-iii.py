class Solution:
    def minMoves(self, nums: List[int]) -> int:
        n=len(nums)

        res=0
        nums.sort()
        for i in range(n):
            res += (nums[n-1]-nums[i])

        return res