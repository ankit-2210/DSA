class Solution:
    def findMin(self, nums: List[int]) -> int:
        n=len(nums)

        low, high=0, n-1
        while low<high:
            mid=low+(high-low)//2

            if nums[mid]<nums[high]:
                high=mid
            elif nums[mid]>nums[high]:
                low=mid+1
            else:
                high-=1

        return nums[low]