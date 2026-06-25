class Solution:
    def countMajoritySubarrays(self, nums: List[int], t: int) -> int:
        n=len(nums)

        temp=[]
        for x in nums:
            if x == t:
                temp.append(1)
            else:
                temp.append(-1)

        mp={0: 1}
        prefix=0
        res=0
        for x in temp:
            prefix += x

            for key, val in mp.items():
                if key<prefix:
                    res += val

            mp[prefix]=mp.get(prefix, 0)+1

        return res