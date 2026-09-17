class Solution:
    def minSumOfLengths(self, arr: List[int], t: int) -> int:
        n=len(arr)

        prefix=[float('inf')]*(n)
        suffix=[float('inf')]*(n)

        temp=float('inf')
        curr=0
        i=0
        for j in range(n):
            curr += arr[j]
            while curr>t:
                curr -= arr[i]
                i+=1

            if curr == t:
                temp=min(temp, j-i+1)
    
            prefix[j]=temp

        curr=0
        temp=float('inf')
        i=n-1
        for j in range(n-1, -1, -1):
            curr += arr[j];
            while curr>t:
                curr -= arr[i];
                i-=1

            if curr == t:
                temp=min(temp, i-j+1)

            suffix[j]=temp
    
        res=float('inf')
        for k in range(n-1):
            if prefix[k] != float('inf') and suffix[k+1] != float('inf'):
                res = min(res, prefix[k]+suffix[k+1])
        
        if res == float('inf'):
            return -1

        return res
