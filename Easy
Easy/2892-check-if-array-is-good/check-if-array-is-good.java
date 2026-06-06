class Solution{
    public boolean isGood(int[] nums){
        int n=nums.length;

        int mx=Integer.MIN_VALUE;
        for(int x: nums){
            mx=Math.max(mx, x);
        }
        HashMap<Integer, Integer> mp=new HashMap<>();
        for(int i=0; i<n; i++){
            mp.put(nums[i], mp.getOrDefault(nums[i], 0)+1);
        }
        for(int i=1; i<mx; i++){
            if(mp.getOrDefault(i, 0) != 1)
                return false;
        }

        if(mp.getOrDefault(mx, 0) != 2)
            return false;

        return true;
    }
}