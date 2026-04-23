class Solution{
    public long[] distance(int[] nums){
        int n=nums.length;

        HashMap<Long, List<Long>> mp=new HashMap<>();
        for(int i=0; i<n; i++){
            mp.computeIfAbsent((long)nums[i], k->new ArrayList<>()).add((long)i);
        }        

        long[] res=new long[n];
        for(List<Long> idx: mp.values()){
            int k=idx.size();
            if(k == 1)
                continue;
            long[] prefix=new long[k];
            prefix[0]=idx.get(0);
            for(int i=1; i<k; i++){
                prefix[i]=prefix[i-1]+idx.get(i);
            }

            for(int i=0; i<k; i++){
                long left=0, right=0;
                if(i>0){
                    left=((long)i*idx.get(i))-prefix[i-1];
                }
                if(i<k-1){
                    right=(prefix[k-1]-prefix[i])-((long)(k-i-1)*idx.get(i));
                }
                res[idx.get(i).intValue()]=left+right;
            }
        }

        return res;
    }
}