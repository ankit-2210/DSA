class Solution:
    def longestMonotonicSubarray(self, nums: List[int]) -> int:
        n=len(nums)

        mx=1
        inc=[1]*n
        for i in range(1, n):
            if nums[i-1]<nums[i]:
                inc[i]=1+inc[i-1]

            mx=max(mx, inc[i])

        dec=[1]*n
        for i in range(n-2, -1, -1):
            if nums[i+1]<nums[i]:
                dec[i]=1+dec[i+1]
    
            mx=max(mx, dec[i])

        return mx
