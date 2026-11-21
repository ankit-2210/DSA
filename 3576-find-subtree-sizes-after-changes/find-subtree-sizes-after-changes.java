class Solution{
    void solve(int u, List<Integer> adj[], String s, int[] p, int[] last){
        int ch=s.charAt(u)-'a';
        int old=last[ch];

        if(u>0 && old != -1){
            p[u]=old;
        }

        last[ch]=u;
        for(int v: adj[u]){
            solve(v, adj, s, p, last);
        }

        last[ch]=old;
    }

    int solve1(int u, List<Integer> tree[], int[] res){
        res[u]=1;
        for(int v: tree[u]){
            res[u] += solve1(v, tree, res);
        }

        return res[u];
    }

    public int[] findSubtreeSizes(int[] p, String s){
        int n=p.length;
        
        List<Integer> adj[]=new ArrayList[n];
        List<Integer> tree[]=new ArrayList[n];
        for(int i=0; i<n; i++){
            adj[i]=new ArrayList<>();
            tree[i]=new ArrayList<>();
        }

        for(int i=1; i<n; i++){
            adj[p[i]].add(i);
        }

        int[] res=new int[n];
        int[] last=new int[26];
        Arrays.fill(last, -1);

        solve(0, adj, s, p, last);

        for(int i=1; i<n; i++){
            tree[p[i]].add(i);
        }

        solve1(0, tree, res);
        return res;


    }
}