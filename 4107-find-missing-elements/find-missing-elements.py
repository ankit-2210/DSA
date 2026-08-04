class Solution:
    def findMissingElements(self, nums: List[int]) -> List[int]:
        n=len(nums)

        mp={}
        for num in nums:
            mp[num]=mp.get(num, 0)+1

        mx=max(nums)
        mn=min(nums)

        res=[]
        i=mn
        while i<=mx:
            if i not in mp:
                res.append(i)
            i+=1

        return res
