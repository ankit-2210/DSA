class Solution{
    public int maxDistance(int[] c){
        int n=c.length;

        int res=Integer.MIN_VALUE;
        for(int i=1; i<n; i++){
            if(c[0] != c[i]){
                res=Math.max(res, i);
            }
        }
        for(int i=n-2; i>=0; i--){
            if(c[i] != c[n-1]){
                res=Math.max(res, n-1-i);
            }
        }

        return res;
    }
}