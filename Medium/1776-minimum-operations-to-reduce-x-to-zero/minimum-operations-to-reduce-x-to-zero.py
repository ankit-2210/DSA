class Solution:
    def minOperations(self, nums: list[int], x: int) -> int:
        n=len(nums)

        res=sum(nums)
        t=res-x

        if t == 0:
            return n
        
        if t<0:
            return -1

        mx=0
        total=0
        i, j=0, 0
        while j<n:
            total += nums[j]

            while total>t:
                total -= nums[i]
                i+=1

            if total == t:
                mx=max(mx, j-i+1)

            j+=1

        if mx == 0:
            return -1

        return n-mx
