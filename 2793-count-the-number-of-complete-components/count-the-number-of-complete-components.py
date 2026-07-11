class Solution:
    def solve(self, node, adj, cnt, visited, n):
        visited[node]=True
        
        cnt[0] += 1
        cnt[1] += len(adj[node])

        for it in adj[node]:
            if not visited[it]:
                self.solve(it, adj, cnt, visited, n)

    def countCompleteComponents(self, n: int, e: List[List[int]]) -> int:
        adj=[[] for _ in range(n)]

        for u, v, in e:
            adj[u].append(v)
            adj[v].append(u)

        count=0
        visited=[False]*n
        for i in range(n):
            if not visited[i]:
                cnt=[0, 0]
                self.solve(i, adj, cnt, visited, n)
                
                ve=cnt[0]
                te=cnt[1]//2;
                if te == ve*(ve-1)//2:
                    count += 1

        return count