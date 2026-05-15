class Solution:
    def isGood(self, nums: List[int]) -> bool:
        n=len(nums)

        mx=max(nums)
        mp={}
        for x in nums:
            mp[x]=mp.get(x, 0)+1

        for i in range(1, mx):
            if mp.get(i, 0) != 1:
                return False

        if mp.get(mx, 0) != 2:
            return False

        return True

