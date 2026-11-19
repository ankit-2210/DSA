class Solution:
    def minimizeSum(self, nums: List[int]) -> int:
        n=len(nums)
        if n<=3:
            return 0

        firstmn=secondmn=thirdmn=float('inf')
        firstmx=secondmx=thirdmx=0
        for i in range(n):
            if nums[i]<firstmn:
                thirdmn=secondmn
                secondmn=firstmn
                firstmn=nums[i]
            elif nums[i]<secondmn:
                thirdmn=secondmn
                secondmn=nums[i]
            elif nums[i]<thirdmn:
                thirdmn=nums[i]

            if nums[i]>firstmx:
                thirdmx=secondmx
                secondmx=firstmx
                firstmx=nums[i]
            elif nums[i]>secondmx:
                thirdmx=secondmx
                secondmx=nums[i]
            elif nums[i]>thirdmx:
                thirdmx=nums[i]

        return min(firstmx-thirdmn, thirdmx-firstmn, secondmx-secondmn)


