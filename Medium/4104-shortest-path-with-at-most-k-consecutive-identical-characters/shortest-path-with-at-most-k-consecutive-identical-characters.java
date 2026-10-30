class Solution{
    public int shortestPath(int n, int[][] e, String l, int k){
        
        List<List<int[]>> adj=new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] it: e){
            adj.get(it[0]).add(new int[]{it[1], it[2]});
        }

        int[][] dist=new int[n][k+2];
        for(int[] row : dist){
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        PriorityQueue<int[]> pq=new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        dist[0][1]=0;
        pq.add(new int[]{0, 0, 1});

        while(!pq.isEmpty()){
            int[] temp=pq.poll();
            int cost=temp[0];
            int node=temp[1];
            int count=temp[2];

            if(cost>dist[node][count])
                continue;
            if(count>k)
                continue;

            for(int[] it: adj.get(node)){
                int nextNode=it[0];
                int weight=it[1];

                int nextCount=(l.charAt(node) == l.charAt(nextNode))?count+1:1;

                if(nextCount>k+1){
                    nextCount=k+1;
                }

                int newCost=cost+weight;
                if(newCost<dist[nextNode][nextCount]){
                    dist[nextNode][nextCount]=newCost;
                    pq.offer(new int[]{newCost, nextNode, nextCount});
                }
            }
        }

        int res=Integer.MAX_VALUE;
        for(int i=0; i<=k; i++){
            res=Math.min(res, dist[n-1][i]);
        }

        if(res == Integer.MAX_VALUE)
            return -1;

        return res;
    }
}