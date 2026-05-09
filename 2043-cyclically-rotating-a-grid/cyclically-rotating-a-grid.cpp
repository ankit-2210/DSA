class Solution{
public:
    vector<vector<int>> rotateGrid(vector<vector<int>> &mat, int k){
        int n=mat.size();
        int m=mat[0].size();

        int layers=min(n, m)/2;
        for(int i=0; i<layers; i++){
            vector<int> vals;
            int top=i, bottom=n-i-1;
            int left=i, right=m-i-1;
            for(int i=left; i<right; i++){
                vals.push_back(mat[top][i]);
            }
            for(int i=top; i<bottom; i++){
                vals.push_back(mat[i][right]);
            }
            for(int i=right; i>left; i--){
                vals.push_back(mat[bottom][i]);
            }
            for(int i=bottom; i>top; i--){
                vals.push_back(mat[i][left]);
            }

            int shift=k%vals.size();
            rotate(vals.begin(), vals.begin()+shift, vals.end());

            int idx=0;
            for(int i=left; i<right; i++){
                mat[top][i]=vals[idx++];
            }
            for(int i=top; i<bottom; i++){
                mat[i][right]=vals[idx++];
            }
            for(int i=right; i>left; i--){
                mat[bottom][i]=vals[idx++];
            }
            for(int i=bottom; i>top; i--){
                mat[i][left]=vals[idx++];
            }
        }

        return mat;


    }
};