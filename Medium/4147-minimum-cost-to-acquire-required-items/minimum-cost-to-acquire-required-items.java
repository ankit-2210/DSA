class Solution{
    public long minimumCost(int c1, int c2, int cb, int n1, int n2){
        
        long k=(long)c1*n1 + (long)c2*n2;
        long l=Math.min(n1, n2)*(long)cb;
        long m=Math.max(n1, n2)*(long)cb;

        long n=0;
        if(n1>n2){
            n=Math.abs(n1-n2)*(long)c1;
        }
        else{
            n=Math.abs(n2-n1)*(long)c2;
        }

        return Math.min(k, Math.min(l+n, m));

    }
}