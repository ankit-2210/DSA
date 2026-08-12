class Solution:
    def maxSubarrayLength(self, nums: List[int], k: int) -> int:
        n=len(nums)

        mp=defaultdict(int)
        res=0
        i, j=0, 0
        while j<n:
            mp[nums[j]]+=1

            while mp[nums[j]]>k and i<=j:
                mp[nums[i]]-=1
                i+=1

            res=max(res, j-i+1)
            j+=1

        return res

