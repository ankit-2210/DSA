class Solution{
    void solve(int node, List<List<Integer>> adj, AtomicInteger v, AtomicInteger t, boolean[] visited, int n){
        visited[node]=true;
        v.incrementAndGet();
        t.addAndGet(adj.get(node).size());

        for(int it: adj.get(node)){
            if(!visited[it]){
                solve(it, adj, v, t, visited, n);
            }
        }
    }

    public int countCompleteComponents(int n, int[][] e){
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] it: e){
            adj.get(it[0]).add(it[1]);
            adj.get(it[1]).add(it[0]);
        }

        int count=0;
        boolean[] visited=new boolean[n];
        for(int i=0; i<n; i++){
            if(!visited[i]){
                AtomicInteger v=new AtomicInteger(0);
                AtomicInteger t=new AtomicInteger(0);
                solve(i, adj, v, t, visited, n);
                
                int ve=v.get();
                int te=t.get()/2;
                if(te == (ve*(ve-1))/2)
                    count++;
            }
        }

        return count;

    }
}