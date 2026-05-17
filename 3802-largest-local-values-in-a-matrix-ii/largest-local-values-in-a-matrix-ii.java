class Solution{
    public int countLocalMaximums(int[][] mat){
        int n=mat.length;
        int m=mat[0].length;

        ArrayList<int[]>[] pos=new ArrayList[201];
        for(int i=0; i<=200; i++){
            pos[i]=new ArrayList<>();
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                // if(mat[i][j] != 0)
                    pos[mat[i][j]].add(new int[]{i, j});
            }
        }

        int res=0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int x=mat[i][j];
                if(x == 0)
                    continue;

                boolean flag=true;
                for(int val=x+1; val<=200 && flag; val++){
                    for(int[] p: pos[val]){
                        int r=p[0];
                        int c=p[1];
                        int dir=Math.abs(r-i);
                        int dic=Math.abs(c-j);

                        if(dir<=x && dic<=x){
                            if(dir == x && dic == x)
                                continue;
                            flag=false;
                            break;
                        }
                    }
                }
                if(flag)
                    res++;
            }
        }

        return res;
    }
}