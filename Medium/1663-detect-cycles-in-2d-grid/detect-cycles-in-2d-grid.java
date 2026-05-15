class Solution{
    static class Node{
        int x, y, px, py;
        Node(int x, int y, int px, int py){
            this.x=x;
            this.y=y;
            this.px=px;
            this.py=py;
        }
    }

    boolean solve(int i, int j, boolean[][] visited, char[][] g, int n, int m){
        Queue<Node> q=new LinkedList<>();
        q.offer(new Node(i, j, -1, -1));
        visited[i][j]=true;
        while(!q.isEmpty()){
            Node curr=q.poll();
            int x=curr.x;
            int y=curr.y;
            int px=curr.px;
            int py=curr.py;

            if(x-1>=0 && g[x-1][y] == g[x][y]){
                if(visited[x-1][y] == false){
                    visited[x-1][y]=true;
                    q.offer(new Node(x-1, y, x, y));
                }
                else if(x-1 != px || y != py)
                    return true;
            }
            if(x+1<n && g[x+1][y] == g[x][y]){
                if(visited[x+1][y] == false){
                    visited[x+1][y]=true;
                    q.offer(new Node(x+1, y, x, y));
                }
                else if(x+1 != px || y != py)
                    return true;
            }
            if(y-1>=0 && g[x][y-1] == g[x][y]){
                if(visited[x][y-1] == false){
                    visited[x][y-1]=true;
                    q.offer(new Node(x, y-1, x, y));
                }
                else if(x != px || y-1 != py)
                    return true;
            }
            if(y+1<m && g[x][y+1] == g[x][y]){
                if(visited[x][y+1] == false){
                    visited[x][y+1]=true;
                    q.offer(new Node(x, y+1, x, y));
                }
                else if(x != px || y+1 != py)
                    return true;
            }
        }

        return false;
    }
    
    public boolean containsCycle(char[][] g){
        int n=g.length;
        int m=g[0].length;

        boolean[][] visited=new boolean[n][m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visited[i][j] == false){
                    if(solve(i, j, visited, g, n, m))
                        return true;
                }
            }
        }

        return false;
    }
}