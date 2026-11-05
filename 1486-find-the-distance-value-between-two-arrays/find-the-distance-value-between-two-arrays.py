class Solution:
    def solve(self, arr2, num, d, m):
        low=0
        high=m-1
        while low<=high:
            mid=low+(high-low)//2

            if abs(arr2[mid]-num)<=d:
                return False
            
            if arr2[mid]<num-d:
                low=mid+1
            else:
                high=mid-1

        return True
    
    def findTheDistanceValue(self, arr1: list[int], arr2: list[int], d: int) -> int:
        n=len(arr1)
        m=len(arr2)

        arr2.sort()
        res=0
        for i in range(n):
            if self.solve(arr2, arr1[i], d, m):
                res+=1

        return res