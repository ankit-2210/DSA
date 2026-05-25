class Solution{
    boolean solve(int idx, String s, int mn, int mx, int[] dp, int n){
        if(idx>=n || s.charAt(idx) == '1')
            return false;

        if(idx == n-1)
            return true;

        if(dp[idx] != -1)
            return dp[idx]==1;

        dp[idx]=0;
        for(int i=mn; i<=mx; i++){
            if(solve(idx+i, s, mn, mx, dp, n)){
                dp[idx]=1;
                return true;
            }
        }

        return false;
    }
    
    public boolean canReach(String s, int mn, int mx){
        int n=s.length();
        if(s.charAt(0) == '1' || s.charAt(n-1) == '1')
            return false;
        int c=0;
        for(int i=0; i<n; i++){
            if(s.charAt(i) == '1'){
                c++;
                if(c>=mx)
                    return false;
            }
            else{
                c=0;
            }
        }

        int[] dp=new int[n];
        Arrays.fill(dp, -1);
        return solve(0, s, mn, mx, dp, n);
        
    }
}