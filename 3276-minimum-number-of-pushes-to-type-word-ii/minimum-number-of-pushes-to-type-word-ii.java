class Solution{
    public int minimumPushes(String w){
        int n=w.length();

        int[] mp=new int[26];
        for(char ch: w.toCharArray()){
            int idx=ch-'a';
            mp[idx]++;
        }

        int[] sorted = Arrays.stream(mp)
                        .boxed()
                        .sorted(Collections.reverseOrder())
                        .mapToInt(Integer::intValue)
                        .toArray();
        
        int t=0;
        int res=0;
        for(int x: sorted){
            if(x == 0)
                break;
            int p=t/8+1;
            res += (p*x);
            t++;
        }

        return res;


    }
}