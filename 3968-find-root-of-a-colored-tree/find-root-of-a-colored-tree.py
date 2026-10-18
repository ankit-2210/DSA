class Solution:
    def findColoredRoot(self, e: list[list[int]], c: str) -> int:
        n=len(c)

        color=[0]*n
        degree=[0]*n
        indegree=[0]*n

        for i in range(n):
            color[i]=0 if c[i] == 'R' else (1 if c[i] == 'B' else 2)

        for u, v in e:
            degree[u]+=1
            degree[v]+=1

            diff=(color[v]-color[u]+3)%3
            if diff == 0:
                return -1

            if diff == 1:
                indegree[v]+=1
            else:
                indegree[u]+=1

        for d in degree:
            if d>3:
                return -1
         
        root=-1
        for i in range(n):
            if indegree[i] == 0:
                if root != -1:
                    return -1
                root=i
            elif indegree[i] != 1:
                return -1
        
        if root == -1 or degree[root]>2:
            return -1

        return root

