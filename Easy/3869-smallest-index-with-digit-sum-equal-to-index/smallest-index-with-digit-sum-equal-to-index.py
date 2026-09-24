class Solution:
    def solve(self, idx, num):
        total=0
        while num>0:
            rem=num%10
            num//=10
            total += rem

        if idx == total:
            return True

        return False

    def smallestIndex(self, nums: List[int]) -> int:
        n=len(nums)

        for i in range(n):
            if self.solve(i, nums[i]):
                return i

        return -1