class Solution:
    def minMoves(self, nums: List[int], l: int) -> int:
        n=len(nums)

        diff=[0]*(2*l+2)
        for i in range(0, n//2):
            a=nums[i]
            b=nums[n-i-1]
            sum=a+b

            low=min(a, b)+1
            high=max(a, b)+l

            diff[2]+=2
            diff[2*l+1]-=2

            diff[low]-=1
            diff[high+1]+=1

            diff[sum]-=1
            diff[sum+1]+=1

        sum=0
        res=float('inf')
        for i in range(2, 2*l+1):
            sum += diff[i]
            res=min(res, sum)

        return res