class Solution{
    public List<List<Integer>> shiftGrid(int[][] g, int k){
        int n=g.length;
        int m=g[0].length;

        k %= (n*m);
        List<List<Integer>> res=new ArrayList<>();
        for(int i=0; i<n; i++){
            List<Integer> row = new ArrayList<>();
            for(int j = 0; j<m; j++){
                row.add(0);
            }
            res.add(row);
        }

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                int x=(i+(j+k)/m)%n;
                int y=(j+k)%m;

                res.get(x).set(y, g[i][j]);
            }
        }

        return res;



    }
}