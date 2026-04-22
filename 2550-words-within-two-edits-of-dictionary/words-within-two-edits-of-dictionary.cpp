class Solution{
public:
    void solve(string &w, string &s, int &t){
        for(int i=0; i<w.size(); i++){
            if(w[i] != s[i])
                t++;
        }
    }

    vector<string> twoEditWords(vector<string> &q, vector<string> &d){
        int n=q.size();
        int m=d.size();

        vector<string> res;
        for(auto it: q){
            string w=it;
            for(int i=0; i<m; i++){
                int t=0;
                string s=d[i];
                solve(w, s, t);
                if(t<=2){
                    res.push_back(w);
                    break;
                }
            }
        }

        return res;

    }
};