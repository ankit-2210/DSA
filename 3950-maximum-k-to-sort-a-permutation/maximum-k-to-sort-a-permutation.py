class Solution:
    def sortPermutation(self, nums: List[int]) -> int:
        n=len(nums)

        bit=-1
        for i in range(n):
            if nums[i] != i:
                if bit == -1:
                    bit=nums[i]
                else:
                    bit&=nums[i]
    
        if bit == -1:
            return 0
            
        return bit

        