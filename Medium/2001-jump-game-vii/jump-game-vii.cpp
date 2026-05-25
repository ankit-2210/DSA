class Solution{
public:
    bool solve(int idx, string &s, int mn, int mx, vector<int> &dp, int n){
        if(idx>=n || s[idx] == '1')
            return false;

        if(idx == n-1)
            return true;

        if(dp[idx] != -1)
            return dp[idx];

        dp[idx]=false;
        for(int i=mn; i<=mx; i++){
            if(solve(idx+i, s, mn, mx, dp, n)){
                return dp[idx]=true;
            }
        }

        return dp[idx];
    }

    bool canReach(string s, int mn, int mx){
        int n=s.size();
        if(s[0] == '1' || s[n-1] == '1')
            return false;
        int c=0;
        for(int i=0; i<n; i++){
            if(s[i] == '1'){
                c++;
                if(c>=mx)
                    return false;
            }
            else{
                c=0;
            }
        }

        vector<int> dp(n, -1);
        return solve(0, s, mn, mx, dp, n);


    }
};