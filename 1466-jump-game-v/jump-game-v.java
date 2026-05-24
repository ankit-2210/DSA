class Solution{
    int solve(int idx, int[] arr, int d, int[] dp, int n){
        if(idx<0 || idx>=n)
            return 0;

        if(dp[idx] != -1)
            return dp[idx];

        int res=1;
        for(int i=idx+1; i<=Math.min(idx+d, n-1); i++){
            if(arr[i]>=arr[idx])
                break;
            res=Math.max(res, 1+solve(i, arr, d, dp, n));
        }
        for(int i=idx-1; i>=Math.max(0, idx-d); i--){
            if(arr[i]>=arr[idx])
                break;
            res=Math.max(res, 1+solve(i, arr, d, dp, n));
        }

        dp[idx]=res;
        return dp[idx];
    }

    public int maxJumps(int[] arr, int d){
        int n=arr.length;

        int[] dp=new int[n];
        Arrays.fill(dp, -1);
        int res=1;
        for(int i=0; i<n; i++){
            res=Math.max(res, solve(i, arr, d, dp, n));
        }

        return res;
    }
}