class Solution{
public:
    int solve(int idx, vector<int> &arr, int d, vector<int> &dp, int n){
        if(idx<0 || idx>=n)
            return 0;

        if(dp[idx] != -1)
            return dp[idx];

        int res=1;
        for(int i=idx+1; i<=min(idx+d, n-1); i++){
            if(arr[i]>=arr[idx])
                break;
            res=max(res, 1+solve(i, arr, d, dp, n));
        }
        for(int i=idx-1; i>=max(0, idx-d); i--){
            if(arr[i]>=arr[idx])
                break;
            res=max(res, 1+solve(i, arr, d, dp, n));
        }

        dp[idx]=res;
        return dp[idx];
    }


    int maxJumps(vector<int> &arr, int d){
        int n=arr.size();

        vector<int> dp(n, -1);
        int res=1;
        for(int i=0; i<n; i++){
            res=max(res, solve(i, arr, d, dp, n));
        }

        return res;
    }
};