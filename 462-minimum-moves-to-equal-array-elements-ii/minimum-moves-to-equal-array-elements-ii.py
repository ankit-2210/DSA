class Solution:
    def minMoves2(self, nums: list[int]) -> int:
        n=len(nums)

        nums.sort()

        res=0
        i, j=0, n-1
        while i<=j:
            res += abs(nums[j]-nums[i])
            i+=1
            j-=1

        return res