class Solution:
    def maximumProduct(self, nums: List[int]) -> int:
        n=len(nums)

        mx1=mx2=mx3=float('-inf')
        mn1=mn2=float('inf');
        for num in nums:
            if num>=mx1:
                mx3=mx2
                mx2=mx1
                mx1=num
            elif num>=mx2:
                mx3=mx2
                mx2=num
            elif num>=mx3:
                mx3=num

            if num<=mn1:
                mn2=mn1
                mn1=num
            elif num<=mn2:
                mn2=num
    
        prod1=mx1*mx2*mx3
        prod2=mn1*mn2*mx1

        return max(prod1, prod2)

