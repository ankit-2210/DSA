class Solution{
public:
    int earliestFinishTime(vector<int> &ls, vector<int> &ld, vector<int> &ws, vector<int> &wd){
        int n=ls.size();
        int m=ws.size();

        int first=INT_MAX;
        for(int i=0; i<n; i++){
            first=min(first, ls[i]+ld[i]);
        }

        int res=INT_MAX;
        for(int i=0; i<m; i++){
            res=min(res, wd[i]+max(first, ws[i]));
        }

        first=INT_MAX;
        for(int i=0; i<m; i++){
            first=min(first, ws[i]+wd[i]);
        }
        for(int i=0; i<n; i++){
            res=min(res, ld[i]+max(first, ls[i]));
        }

        return res;
    }
};