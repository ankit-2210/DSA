class Solution{
    int find(int node, int[] parent){
        if(node == parent[node])
            return node;

        return parent[node]=find(parent[node], parent);
    }

    void solve(int a, int b, int[] nums, int[] parent, int[] rank, int n){
        int x=find(a, parent);
        int y=find(b, parent);

        if(x == y)
            return;

        if(rank[x]<rank[y]){
            parent[x]=y;
            rank[y]++;
        }
        else{
            parent[y]=x;
            rank[x]++;
        }

    }

    public boolean[] pathExistenceQueries(int n, int[] nums, int mx, int[][] q){
        int[] parent=new int[n];
        int[] rank=new int[n];
        Arrays.fill(rank, 0);

        for(int i=0; i<n; i++){
            parent[i]=i;
        }
        
        for(int i=1; i<n; i++){
            if(nums[i]-nums[i-1]<=mx){
                solve(i-1, i, nums, parent, rank, n);
            }
        }

        boolean[] res=new boolean[q.length];
        Arrays.fill(res, false);
        for(int i=0; i<q.length; i++){
            int x=find(q[i][0], parent);
            int y=find(q[i][1], parent);

            if(x == y){
                res[i]=true;
            }
        }

        return res;

    }
}