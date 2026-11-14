class Solution:
    def minimumSumSubarray(self, nums: List[int], l: int, r: int) -> int:
        n=len(nums)

        res=float('inf')
        for k in range(l, r+1):
            curr=0
            i, j=0, 0
            while j<n:
                curr += nums[j]
                while j-i+1 == k:
                    if curr>0:
                        res=min(res, curr)

                    curr -= nums[i]
                    i+=1
                
                j+=1

        if res == float('inf'):
            return -1

        return res