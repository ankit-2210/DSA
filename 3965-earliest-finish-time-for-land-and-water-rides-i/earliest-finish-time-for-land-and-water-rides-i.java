class Solution{
    public int earliestFinishTime(int[] ls, int[] ld, int[] ws, int[] wd){
        int n=ls.length;
        int m=ws.length;

        int first=Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            first=Math.min(first, ls[i]+ld[i]);
        }

        int res=Integer.MAX_VALUE;
        for(int i=0; i<m; i++){
            res=Math.min(res, wd[i]+Math.max(first, ws[i]));
        }

        first=Integer.MAX_VALUE;
        for(int i=0; i<m; i++){
            first=Math.min(first, ws[i]+wd[i]);
        }
        for(int i=0; i<n; i++){
            res=Math.min(res, ld[i]+Math.max(first, ls[i]));
        }

        return res;

    }
}