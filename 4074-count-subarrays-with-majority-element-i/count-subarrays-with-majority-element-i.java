class Solution{
    public int countMajoritySubarrays(int[] nums, int t){
        int n=nums.length;

        int[] temp=new int[n];
        for(int i=0; i<n; i++){
            if(nums[i] == t){
                temp[i]=1;
            }
            else{
                temp[i]=-1;
            }
        }

        HashMap<Integer, Integer> mp=new HashMap<>();
        mp.put(0, 1);

        int prefix=0;
        int res=0;
        for(int i=0; i<n; i++){
            prefix += temp[i];

            for(Map.Entry<Integer, Integer> it: mp.entrySet()){
                if(it.getKey()<prefix){
                    res += it.getValue();
                }
            }

            mp.put(prefix, mp.getOrDefault(prefix, 0)+1);
        }

        return res;

    }
}