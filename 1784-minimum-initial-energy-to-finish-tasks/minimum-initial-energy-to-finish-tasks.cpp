class Solution{
public:
    int minimumEffort(vector<vector<int>> &t){
        int n=t.size();

        sort(t.begin(), t.end(), [](vector<int> &a, vector<int> &b){
            return a[1]-a[0]>b[1]-b[0];
        });

        // for(auto it: t){
        //     cout << it[0] << " " << it[1] << endl;
        // }
        int res=0;
        int curr=0;
        for(auto it: t){
            int ac=it[0];
            int mn=it[1];
            if(curr<mn){
                res += (mn-curr);
                curr=mn;
            }
            curr -= ac;
        }

        return res;
    }
};