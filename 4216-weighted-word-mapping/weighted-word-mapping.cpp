class Solution{
public:
    int solve(string &s, vector<int> &wt, int m){
        int res=0;
        for(int i=0; i<s.size(); i++){
            res += wt[s[i]-97];
        }

        // cout << res << endl;

        return res;
    }

    string mapWordWeights(vector<string> &w, vector<int> &wt){
        int n=w.size();
        int m=wt.size();

        string str="";
        for(int i=0; i<n; i++){
            string s=w[i];

            int t=solve(s, wt, m);
            // cout << t%26 << " ";
            str += 'z'-(t%26);
        }

        return str;


    }
};