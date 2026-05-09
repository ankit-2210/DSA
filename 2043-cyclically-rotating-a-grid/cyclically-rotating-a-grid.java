class Solution {
    public int[][] rotateGrid(int[][] mat, int k){
        int n=mat.length;
        int m=mat[0].length;

        int layers=Math.min(n, m)/2;
        for(int l=0; l<layers; l++){
            List<Integer> vals=new ArrayList<>();
            int top=l, bottom=n-l-1;
            int left=l, right=m-l-1;
            for(int i=left; i<right; i++){
                vals.add(mat[top][i]);
            }
            for(int i=top; i<bottom; i++){
                vals.add(mat[i][right]);
            }
            for(int i=right; i>left; i--){
                vals.add(mat[bottom][i]);
            }
            for(int i=bottom; i>top; i--){
                vals.add(mat[i][left]);
            }

            int shift=k%vals.size();
            // rotate(vals.begin(), vals.begin()+shift, vals.end());
            Collections.rotate(vals, -shift);

            int idx=0;
            for(int i=left; i<right; i++){
                mat[top][i]=vals.get(idx++);
            }
            for(int i=top; i<bottom; i++){
                mat[i][right]=vals.get(idx++);
            }
            for(int i=right; i>left; i--){
                mat[bottom][i]=vals.get(idx++);
            }
            for(int i=bottom; i>top; i--){
                mat[i][left]=vals.get(idx++);
            }
        }

        return mat;
    }
}