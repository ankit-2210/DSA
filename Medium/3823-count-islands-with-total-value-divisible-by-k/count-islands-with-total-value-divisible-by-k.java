class Solution{
    void solve(int i, int j, AtomicLong sum, int[][] g, boolean[][] visited, int n, int m){
        if(i<0 || i>=n || j<0 || j>=m || visited[i][j] == true || g[i][j]<=0)
            return;

        sum.addAndGet(g[i][j]);
        visited[i][j]=true;

        solve(i+1, j, sum, g, visited, n, m);
        solve(i-1, j, sum, g, visited, n, m);
        solve(i, j+1, sum, g, visited, n, m);
        solve(i, j-1, sum, g, visited, n, m);

    }

    public int countIslands(int[][] g, int k){
        int n=g.length;
        int m=g[0].length;

        int res=0;
        boolean[][] visited=new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(g[i][j]>0 && !visited[i][j]){
                    AtomicLong sum=new AtomicLong(0);
                    solve(i, j, sum, g, visited, n, m);

                    if(sum.get()%k == 0){
                        res++;
                    }
                }
            }
        }

        return res;

    }
}