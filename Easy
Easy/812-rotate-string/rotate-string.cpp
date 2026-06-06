class Solution{
public:
    vector<int> solve(string g, int n){
        vector<int> lps(n, 0);
        int i=1, len=0;
        while(i<n){
            if(g[i] == g[len]){
                len++;
                lps[i++]=len;
            }
            else{
                if(len != 0){
                    len=lps[len-1];
                }
                else{
                    lps[i++]=0;
                }
            }
        }
        return lps;
    }

    bool rotateString(string s, string g){
        int n=s.size();
        int m=g.size();

        if(n != m)
            return false;

        string t=s+s;
        vector<int> lps=solve(g, m);
        int i=0, j=0;
        while(i<t.size()){
            if(t[i] == g[j]){
                i++;
                j++;
            }
            if(j == m)
                return true;
            else if(t[i] != g[j]){
                if(j != 0){
                    j=lps[j-1];
                }
                else{
                    i++;
                }
            }
        }

        return false;

    }
};