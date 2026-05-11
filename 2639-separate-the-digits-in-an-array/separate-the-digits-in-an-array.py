class Solution:
    def separateDigits(self, nums: List[int]) -> List[int]:
        n=len(nums)

        s=""
        for i in nums:
            s += str(i) 

        res=[]
        for ch in s:
            res.append(int(ch))

        return res