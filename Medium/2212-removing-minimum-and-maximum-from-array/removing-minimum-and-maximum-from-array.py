class Solution:
    def minimumDeletions(self, nums: List[int]) -> int:
        n=len(nums)

        mxIndex = max(range(n), key=lambda i: nums[i])
        mnIndex = min(range(n), key=lambda i: nums[i])

        mx = max(mxIndex, mnIndex)
        mn = min(mxIndex, mnIndex)

        return min(mx+1, n-mn, mn+(n-mx)+1)
        


