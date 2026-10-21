class Solution{
    boolean solve(String s){
        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i)>s.charAt(i+1))
                return false;
        }

        return true;
    }

    public int minOperations(String s){
        int n=s.length();

        if(solve(s))
            return 0;
    
        if(n == 2 && solve(s) == false)
            return -1;

        int lidx=-1, hidx=-1;
        char lch='z', rch='a';
        for(int i=0; i<n; i++){
            if(s.charAt(i)>=rch){
                rch=s.charAt(i);
                hidx=i;
            }
            if(s.charAt(i)<lch){
                lch=s.charAt(i);
                lidx=i;
            }
        }

        if(lidx == 0 || hidx == n-1)
            return 1;
        if(lidx == n-1 && hidx == 0)
            return 3;

        return 2;
    }
}