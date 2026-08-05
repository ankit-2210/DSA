class Solution:
    def remainingMethods(self, n: int, k: int, invo: List[List[int]]) -> List[int]:

        adj=[[] for _ in range(n)]

        for u, v in invo:
            adj[u].append(v)

        visited=[False]*n
        q=deque([k])
        visited[k]=True

        while q:
            node=q.popleft()

            for it in adj[node]:
                if not visited[it]:
                    q.append(it)
                    visited[it]=True


        flag=True
        for i in range(n):
            if not visited[i]:
                for it in adj[i]:
                    if visited[it]:
                        flag=False
                        break
            if not flag:
                break

        if not flag:
            return list(range(n))

        return [i for i in range(n) if not visited[i]]


        