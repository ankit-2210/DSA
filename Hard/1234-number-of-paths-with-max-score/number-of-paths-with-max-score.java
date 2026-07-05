class Solution{
    static final int mod=1000000007;
    void solve(int i, int j, List<String> b, int[][] score, int[][] ways, boolean[][] visited, int n, int m){
        if(i<0 || j<0 || b.get(i).charAt(j) == 'X')
            return;

        if(visited[i][j] == true)
            return;

        visited[i][j]=true;
        if(i == 0 && j == 0){
            score[0][0]=0;
            ways[0][0]=1;
            return;
        }

        solve(i-1, j, b, score, ways, visited, n, m);
        solve(i, j-1, b, score, ways, visited, n, m);
        solve(i-1, j-1, b, score, ways, visited, n, m);

        int best=Integer.MIN_VALUE;
        if(i-1>=0){
            best=Math.max(best, score[i-1][j]);
        }
        if(j-1>=0){
            best=Math.max(best, score[i][j-1]);
        }
        if(i-1>=0 && j-1>=0){
            best=Math.max(best, score[i-1][j-1]);
        }

        if(best == Integer.MIN_VALUE){
            score[i][j]=Integer.MIN_VALUE;
            ways[i][j]=0;
            return;
        }

        long count=0;
        if(i-1>=0 && score[i-1][j] == best){
            count += ways[i-1][j];
        }
        if(j-1>=0 && score[i][j-1] == best){
            count += ways[i][j-1];
        }
        if(i-1>=0 && j-1>=0 && score[i-1][j-1] == best){
            count += ways[i-1][j-1];
        }

        count%=mod;

        char ch=b.get(i).charAt(j);
        int val=(ch == 'E' || ch == 'S')?0:ch-'0';

        score[i][j]=best+val;
        ways[i][j]=(int)count;
    }

    public int[] pathsWithMaxScore(List<String> b){
        int n=b.size();
        int m=b.get(0).length();

        int[][] score=new int[n][m];
        int[][] ways=new int[n][m];
        boolean[][] visited=new boolean[n][m];
        for(int[] row: score){
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        solve(n-1, m-1, b, score, ways, visited, n, m);

        // for(int i=0; i<n; i++){
        //     for(int j=0; j<m; j++){
        //         System.out.print(score[i][j] + " ");
        //     }
        //      System.out.println();
        // }

        // for(int i=0; i<n; i++){
        //     for(int j=0; j<m; j++){
        //         System.out.print(ways[i][j] + " ");
        //     }
        //      System.out.println();
        // }

        if(ways[n-1][m-1] == 0)
            return new int[]{0, 0};


        return new int[]{score[n-1][m-1], ways[n-1][m-1]};

    }
}