class Solution{
    void solve(int[][] e, int s, int t, boolean[] visited, int []high, int n){
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] it: e){
            adj.get(it[0]).add(it[1]);
            adj.get(it[1]).add(it[0]);
            high[0]=Math.max(high[0], it[2]);
        }
        
        Queue<Integer> q=new LinkedList<>();
        q.offer(s);
        visited[s]=true;
        while(!q.isEmpty()){
            int u=q.poll();
            for(int it: adj.get(u)){
                if(!visited[it]){
                    q.offer(it);
                    visited[it]=true;
                }
            }
        }
    }

    boolean solve1(int[][] e, int s, int t, int k, int mid, int n){
        ArrayList<ArrayList<int[]>> adj=new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] it: e){
            int c=(it[2]>mid?1:0);
            adj.get(it[0]).add(new int[]{it[1], c});
            adj.get(it[1]).add(new int[]{it[0], c});
        }

        Deque<Integer> dq=new ArrayDeque<>();
        int[] dist=new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[s]=0;
        dq.offerFirst(s);
        while(!dq.isEmpty()){
            int u=dq.pollFirst();
            for(int[] it: adj.get(u)){
                int v=it[0];
                int wt=it[1];
                if(wt+dist[u]<dist[v]){
                    dist[v]=wt+dist[u];
                    if(wt == 0){
                        dq.offerFirst(v);
                    }
                    else{
                        dq.offerLast(v);
                    }
                }
            }
        }

        if(dist[t]<=k)
            return true;
        return false;
    }
    
    public int minimumThreshold(int n, int[][] e, int s, int t, int k){
        if(s == t)
            return 0;

        int low=0;
        int[] h=new int[1];
        boolean[] visited=new boolean[n];
        solve(e, s, t, visited, h, n);
        if(!visited[t])
            return -1;

        int res=h[0];
        int high=h[0];
        while(low<=high){
            int mid=low+(high-low)/2;
            if(solve1(e, s, t, k, mid, n)){
                res=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }

        return res;
    }
}