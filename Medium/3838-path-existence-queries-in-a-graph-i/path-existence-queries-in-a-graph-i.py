class Solution:
    def find(self, node, parent):
        if node == parent[node]:
            return node

        parent[node]=self.find(parent[node], parent)
        return parent[node]

    def solve(self, a, b, parent, rank):
        x=self.find(a, parent)
        y=self.find(b, parent)

        if x == y:
            return

        if rank[x]<rank[y]:
            parent[x]=y
            rank[y] += 1
        else:
            parent[y]=x
            rank[x] += 1
    
    def pathExistenceQueries(self, n: int, nums: List[int], mx: int, q: List[List[int]]) -> List[bool]:
        parent=list(range(n))
        rank=[0]*n
        
        for i in range(1, n):
            if nums[i]-nums[i-1]<=mx:
                self.solve(i-1, i, parent, rank)

        res=[False]*len(q)
        for i, (u, v) in enumerate(q):
            x=self.find(u, parent)
            y=self.find(v, parent)

            if x == y:
                res[i]=True

        return res