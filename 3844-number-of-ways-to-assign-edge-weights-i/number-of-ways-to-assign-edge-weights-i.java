class Solution{
    static final long mod = 1_000_000_007L;

    void solve(int node, int parent, int depth, List<Integer> []adj, int []info){
        if(depth>info[0]){
            info[0]=depth;
            info[1]=node;
        }

        for(int it: adj[node]){
            if(it != parent){
                solve(it, node, depth+1, adj, info);
            }
        }
    }

    int power(long a, long b){
        long p=1;
        while(b>0){
            if((b&1) == 1){
                p=(p*a)%mod;
            }
            a=(a*a)%mod;
            b>>=1;
        }

        return (int)p;
    }


    public int assignEdgeWeights(int[][] e) {
        int n=e.length+1;

        List<Integer> adj[] = new ArrayList[n+1];
        for(int i=0; i<=n; i++){
            adj[i]=new ArrayList<>();
        }

        for(int[]it: e){
            adj[it[0]].add(it[1]);
            adj[it[1]].add(it[0]);
        }

        int[] info=new int[2];
        solve(1, 0, 0, adj, info);
        int mxdepth=info[0];
        return power(2, mxdepth-1);
    }
}