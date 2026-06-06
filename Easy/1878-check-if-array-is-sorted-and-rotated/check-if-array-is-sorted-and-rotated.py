class Solution:
    def check(self, nums: List[int]) -> bool:
        n=len(nums)

        c=0
        for i in range(1, n):
            if nums[i]<nums[i-1]:
                c+=1

        if nums[0]<nums[n-1]:
            c+=1

        if c>1:
            return False

        return True