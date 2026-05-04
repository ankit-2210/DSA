class Solution{
    public void rotate(int[][] mat){
        int n=mat.length;
    
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                int t=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=t;
            }
        }

        for(int i=0; i<n; i++){
            int left=0, right=n-1;
            while(left<right){
                int t=mat[i][left];
                mat[i][left]=mat[i][right];
                mat[i][right]=t;
                left++;
                right--;
            }
        }
    }
}