class Solution{
    void solve(int node, List<List<int[]>> adj, boolean[] visited, AtomicInteger res, int n){

        visited[node]=true;
        for(int[] it: adj.get(node)){
            res.set(Math.min(res.get(), it[1]));
            if(visited[it[0]] == false){
                solve(it[0], adj, visited, res, n);
            }
        }


    }

    public int minScore(int n, int[][] r){
         int m=r.length;

        List<List<int[]>> adj=new ArrayList<>(n+1);
        for(int i=0; i<=n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] it : r){
            adj.get(it[0]).add(new int[]{it[1], it[2]});
            adj.get(it[1]).add(new int[]{it[0], it[2]});
        }

        AtomicInteger res=new AtomicInteger(Integer.MAX_VALUE);
        boolean[] visited=new boolean[n+1];
        solve(1, adj, visited, res, n);

        return res.get();


    }
}