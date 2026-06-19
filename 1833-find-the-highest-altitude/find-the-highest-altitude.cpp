class Solution{
public:
    int largestAltitude(vector<int> &g){
        int n=g.size();

        int mx=0;
        int prefix=0;
        for(int i=0; i<n; i++){
            prefix += g[i];
            mx=max(mx, prefix);
        }

        return mx;
    }
};