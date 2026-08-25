class Solution:
    def missingMultiple(self, nums: List[int], k: int) -> int:
        n=len(nums)

        st=set(nums)

        t=k
        while t in st:
            t += k
       
        return t

