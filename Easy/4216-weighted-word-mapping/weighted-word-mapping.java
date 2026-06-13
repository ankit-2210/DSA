class Solution{
    int solve(String s, int[] wt, int m){
        int res=0;
        for(int i=0; i<s.length(); i++){
            res += wt[s.charAt(i)-'a'];
        }

        return res;
    }
    
    public String mapWordWeights(String[] w, int[] wt){
        int n=w.length;
        int m=wt.length;

        StringBuilder str=new StringBuilder();
        for(int i=0; i<n; i++){
            String s=w[i];

            int t=solve(s, wt, m);
            // cout << t%26 << " ";
            str.append((char)('z'-(int)(t%26)));
        }

        return str.toString();
    }
}