class Solution{
    long solve(long num){
        long r=0;
        while(num>0){
            int rem=(int)num%10;
            num/=10;
            r=r*10+rem;
        }

        return r;
    }

    int solve1(int idx, int num, Map<Integer, List<Integer>> mp){
        List<Integer> t=mp.get(num);
        int low=0, high=t.size()-1;
        int res=-1;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(t.get(mid)>idx){
                res=t.get(mid);
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return res;
    }

    public int minMirrorPairDistance(int[] nums){
        int n=nums.length;

        Map<Integer, List<Integer>> mp=new HashMap<>();
        for(int i=0; i<n; i++){
            mp.computeIfAbsent(nums[i], k->new ArrayList<>()).add(i);
        }

        int res=Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            int num=nums[i];
        
            int rev=(int)solve(num);
            if(!mp.containsKey(rev))
                continue;

            int idx=solve1(i, rev, mp);
            if(idx != -1){
                res=Math.min(res, Math.abs(idx-i));
            }
        }

        if(res == Integer.MAX_VALUE)
            return -1;
        return res;
    }
}