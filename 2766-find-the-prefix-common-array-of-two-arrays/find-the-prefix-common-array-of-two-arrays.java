class Solution{
    public int[] findThePrefixCommonArray(int[] a, int[] b){
        int n=a.length;
        int m=b.length;

        int[] prefix=new int[n];
        int c=0;
        HashMap<Integer, Integer> mp=new HashMap<>();
        for(int i=0; i<n; i++){
            if(a[i] == b[i]){
                mp.put(a[i], mp.getOrDefault(a[i], 0)+2);
                c++;
            }
            else{
                mp.put(a[i], mp.getOrDefault(a[i], 0)+1);
                mp.put(b[i], mp.getOrDefault(b[i], 0)+1);
                if(mp.get(a[i]) == 2)
                    c++;
                if(mp.get(b[i]) == 2)
                    c++;
            }
            prefix[i]=c;
        }

        return prefix;
    }
}