class Solution:
    def maxValue(self, nums: List[int]) -> List[int]:
        n=len(nums)

        prefix=[0]*(n);
        prefix[0]=nums[0]
        for i in range(1, n):
            prefix[i]=max(prefix[i-1], nums[i])

        suffixmin=nums[n-1]
        res=[0]*(n)
        res[n-1]=prefix[n-1]
        for i in range(n-2, -1, -1):
            if prefix[i]>suffixmin:
                res[i]=res[i+1]
            else:
                res[i]=prefix[i]
            suffixmin=min(suffixmin, nums[i])
        
        return res