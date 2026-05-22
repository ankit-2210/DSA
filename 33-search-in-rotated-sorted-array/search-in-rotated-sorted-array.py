class Solution:
    def search(self, nums: List[int], t: int) -> int:
        n=len(nums)

        low, high=0, n-1
        while low<=high:
            mid=low+(high-low)//2
            if nums[mid] == t:
                return mid
            elif nums[low]<=nums[mid]:
                if nums[low]<=t and t<nums[mid]:
                    high=mid-1
                else:
                    low=mid+1
            else:
                if nums[mid]<t and t<=nums[high]:
                    low=mid+1
                else:
                    high=mid-1
                
        return -1