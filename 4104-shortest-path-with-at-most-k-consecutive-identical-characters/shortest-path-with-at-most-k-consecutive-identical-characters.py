import heapq
import sys

class Solution(object):
    def shortestPath(self, n, e, l, k):

        adj=[[] for _ in range(n)]
        for u, v, w in e:
            adj[u].append((v, w))

        dist=[[sys.maxsize]*(k+2) for _ in range(n)]

        pq=[]
        dist[0][1]=0;
        heapq.heappush(pq, (0, 0, 1))

        while pq:
            cost, node, count=heapq.heappop(pq)

            if cost>dist[node][count]:
                continue
            if count>k:
                continue

            for nextNode, weight in adj[node]:
                if l[node] == l[nextNode]:
                    nextCount=count+1
                else:
                    nextCount=1

                if nextCount>k+1:
                    nextCount=k+1

                newCost=cost+weight
                if newCost<dist[nextNode][nextCount]:
                    dist[nextNode][nextCount]=newCost
                    heapq.heappush(pq, (newCost, nextNode, nextCount))
                

        res=sys.maxsize
        for i in range(k+1):
            res=min(res, dist[n-1][i])

        return -1 if res == sys.maxsize else res
        