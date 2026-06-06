class Solution{
    public boolean hasValidPath(int[][] g){
        int n=g.length;
        int m=g[0].length;

        int[][][] v={{},{{0, -1}, {0, 1}}, {{-1, 0}, {1, 0}}, {{0, -1}, {1, 0}}, {{0, 1}, {1, 0}}, {{0, -1}, {-1, 0}}, {{0, 1}, {-1, 0}}};

        boolean[][] visited=new boolean[n][m];
        Queue<int[]> q=new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0][0]=true;
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int i=curr[0];
            int j=curr[1];

            if(i == n-1 && j == m-1)
                return true;

            for(int[] it: v[g[i][j]]){
                int x=it[0];
                int y=it[1];
                int nx=i+x;
                int ny=j+y;
                if(nx<0 || nx>=n || ny<0 || ny>=m || visited[nx][ny] == true)
                    continue;
               
                boolean flag=false;
                for(int[] it1: v[g[nx][ny]]){
                    int dx=it1[0];
                    int dy=it1[1];
                    if(dx == -x && dy == -y){
                        flag=true;
                        break;
                    }
                }

                if(flag == true){
                    visited[nx][ny]=true;
                    q.offer(new int[]{nx, ny});
                }
            }
        }

        return false;
    }
}