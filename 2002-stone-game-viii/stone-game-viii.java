class Solution{
    public int stoneGameVIII(int[] s){
        int n=s.length;

        int[] prefix=new int[n];
        prefix[0]=s[0];
        for(int i=1; i<n; i++){
            prefix[i]=prefix[i-1]+s[i];
        }

        int res=prefix[n-1];
        int i=n-2;
        while(i>=1){
            res=Math.max(res, prefix[i]-res);
            i--;
        }

        return res;

    }
}