class Solution{
    boolean solve(List<List<long[]>> adj, long mid, long k, int n){
        long[] dist=new long[n];
        Arrays.fill(dist, k+1);

        PriorityQueue<long[]> pq=new PriorityQueue<>((a, b)->Long.compare(a[0], b[0]));
        dist[0]=0;
        pq.offer(new long[]{0, 0});

        while(!pq.isEmpty()){
            long[] curr=pq.poll();
            
            long cost=curr[0];
            int node=(int)curr[1];

            if(cost>dist[node])
                continue;

            if(node == n-1)
                return true;

            for(long[] it: adj.get(node)){
                int next=(int)it[0];
                long wt=it[1];

                if(wt<mid)
                    continue;
                if(cost+wt<dist[next]){
                    dist[next]=wt+cost;
                    pq.offer(new long[]{dist[next], next});
                }
            }

        }

        return false;


    }

    public int findMaxPathScore(int[][] e, boolean[] online, long k){
        int n=online.length;

        List<List<long[]>> adj=new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        
        long low=0, high=0;
        for(int[] it: e){
            high=Math.max(high, it[2]);
            if(online[it[0]] == false || online[it[1]] ==  false)
                continue;
            adj.get(it[0]).add(new long[]{it[1], it[2]});
        }

        long res=-1;
        while(low<=high){
            long mid=low+(high-low)/2;
            if(solve(adj, mid, k, n)){
                res=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }

        return (int)res;
    }
}