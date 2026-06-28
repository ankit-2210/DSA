class Solution:
    def maximumElementAfterDecrementingAndRearranging(self, arr: List[int]) -> int:
        n=len(arr)

        arr.sort()
        arr[0]=1
        res=0
        i=1
        while i<n:
            if arr[i]-arr[i-1]>1:
                arr[i]=arr[i-1]+1
            i+=1

        return arr[n-1]