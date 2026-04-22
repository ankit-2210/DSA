class Solution{
    void solve(String w, String s, int[] t){
        for(int i=0; i<w.length(); i++){
            if(w.charAt(i) != s.charAt(i))
                t[0]++;
        }
    }

    public List<String> twoEditWords(String[] q, String[] d){
        int n=q.length;
        int m=d.length;

        List<String> res=new ArrayList<>();
        for(String it: q){
            String w=it;
            for(int i=0; i<m; i++){
                int[] t=new int[1];
                String s=d[i];
                solve(w, s, t);
                if(t[0]<=2){
                    res.add(w);
                    break;
                }
            }
        }

        return res;
    }
}