class Solution:
    def solve(self, i, j, g, n, m):
    
        q=deque([(i, j)])
        g[i][j]=1

        flag=True
        while q:
            x, y = q.popleft()

            if x == 0 or x == n-1 or y == 0 or y == m-1:
                flag=False

            if x-1>=0 and g[x-1][y] == 0:
                g[x-1][y]=1
                q.append((x-1, y))
            if x+1<n and g[x+1][y] == 0:
                g[x+1][y]=1
                q.append((x+1, y))
            if y-1>=0 and g[x][y-1] == 0:
                g[x][y-1]=1
                q.append((x, y-1))
            if y+1<m and g[x][y+1] == 0:
                g[x][y+1]=1;
                q.append((x, y+1))

        return flag


    def closedIsland(self, g: list[list[int]]) -> int:
        n=len(g)
        m=len(g[0])

        res=0
        for i in range(n):
            for j in range(m):
                if g[i][j] == 0:
                    if(self.solve(i, j, g, n, m)):
                        res+=1

        return res