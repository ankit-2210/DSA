class Solution:
    def solve(self, num):
        total=0
        while num>0:
            total += (num%10)
            num//=10

        return total
    
    def minSwaps(self, nums: List[int]) -> int:
        n=len(nums)

        v=[(nums[i], i) for i in range(n)]
        v.sort(key=lambda x: (self.solve(x[0]), x[0], x[1]))

        pos=[0]*n
        for i in range(n):
            pos[v[i][1]]=i

        visited=[False]*n
        res=0
        for i in range(n):
            if visited[i] or pos[i] == i:
                continue

            c=0
            j=i
            while not visited[j]:
                visited[j]=True
                j=pos[j]
                c+=1

            res += c-1

        return res

