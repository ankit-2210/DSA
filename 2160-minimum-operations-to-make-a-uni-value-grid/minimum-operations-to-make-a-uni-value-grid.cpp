class Solution{
public:
    int minOperations(vector<vector<int>> &g, int x){
        int n=g.size();
        int m=g[0].size();

        vector<int> temp;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                temp.push_back(g[i][j]);
            }
        }
        
        sort(temp.begin(), temp.end());
        int rem=temp[0]%x;
        for(int i=1; i<n*m; i++){
            if(temp[i]%x != rem)
                return -1;
        }
        int mid=temp[(n*m-1)/2];
        // cout << mid << endl;
        int res=0;
        for(int i=0; i<n*m; i++){
            res += abs(temp[i]-mid)/x;
        }

        return res;


    }
};