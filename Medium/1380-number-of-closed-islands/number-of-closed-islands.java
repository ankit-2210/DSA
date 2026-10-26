class Solution{
    boolean solve(int i, int j, int[][] g, int n, int m){
    
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{i, j});
        g[i][j]=1;

        boolean flag=true;
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int x=curr[0];
            int y=curr[1];

            if(x == 0 || x == n-1 || y == 0 || y == m-1)
                flag=false;

            if(x-1>=0 && g[x-1][y] == 0){
                g[x-1][y]=1;
                q.offer(new int[]{x-1, y});
            }
            if(x+1<n && g[x+1][y] == 0){
                g[x+1][y]=1;
                q.offer(new int[]{x+1, y});
            }
            if(y-1>=0 && g[x][y-1] == 0){
                g[x][y-1]=1;
                q.offer(new int[]{x, y-1});
            }
            if(y+1<m && g[x][y+1] == 0){
                g[x][y+1]=1;
                q.offer(new int[]{x, y+1});
            }
        }

        return flag;

    }

    public int closedIsland(int[][] g){
        int n=g.length;
        int m=g[0].length;

        int res=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(g[i][j] == 0){
                    
                    if(solve(i, j, g, n, m)){
                        res++;
                    }
                }
            }
        }

        return res;


    }
}