class Solution{
    public String[] createGrid(int n, int m){
        
        String[] res=new String[n];
        for(int i=0; i<n; i++){
            StringBuilder temp=new StringBuilder();
            for(int j=0; j<m; j++){
                if(i == 0 || j == m-1){
                    temp.append('.');
                }
                else{
                    temp.append('#');
                }
            }

            res[i]=temp.toString();
        }

        return res;

    }
}