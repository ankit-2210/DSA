class Solution:
    def solve(self, i, j, g, visited, n, m) -> int:
        if i<0 or i>=n or j<0 or j>=m or visited[i][j] or g[i][j]<=0:
            return 0

        total=g[i][j]
        visited[i][j]=True

        total += self.solve(i+1, j, g, visited, n, m)
        total += self.solve(i-1, j, g, visited, n, m)
        total += self.solve(i, j+1, g, visited, n, m)
        total += self.solve(i, j-1, g, visited, n, m)

        return total

    def countIslands(self, g: List[List[int]], k: int) -> int:
        n=len(g)
        m=len(g[0])

        res=0
        visited=[[False]*m for _ in range(n)]
        for i in range(n):
            for j in range(m):
                if g[i][j]>0 and not visited[i][j]:
                    total=self.solve(i, j, g, visited, n, m)

                    if total%k == 0:
                        res+=1

        return res