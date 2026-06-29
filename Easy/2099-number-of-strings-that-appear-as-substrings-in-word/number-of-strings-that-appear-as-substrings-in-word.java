class Solution{
    public int numOfStrings(String[] p, String w){
        int n=p.length;

        int res=0;
        for(String sub: p){
            if(w.contains(sub))
                res++;
        }

        return res;
    }
}