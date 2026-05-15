class Solution{
    int[] solve(String g, int n){
        int[] lps=new int[n];   
        int i=1, len=0;
        while(i<n){
            if(g.charAt(i) == g.charAt(len)){
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
    
    public boolean rotateString(String s, String g){
        int n=s.length();
        int m=g.length();

        if(n != m)
            return false;

        String t=s+s;
        int[] lps=solve(g, m);
        int i=0, j=0;
        while(i<t.length()){
            if(t.charAt(i) == g.charAt(j)){
                i++;
                j++;
            }
            if(j == m)
                return true;
            else if(i<t.length() && t.charAt(i) != g.charAt(j)){
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
}