class Solution{
    public int maxSubarrayLength(int[] nums, int k){
        int n=nums.length;

        HashMap<Integer, Integer> mp=new HashMap<>();
        int res=0;
        int i=0, j=0;
        while(j<n){
            mp.put(nums[j], mp.getOrDefault(nums[j], 0)+1);

            while(mp.get(nums[j])>k && i<=j){
                mp.put(nums[i], mp.getOrDefault(nums[i], 0)-1);
                i++;
            }   

            res=Math.max(res, j-i+1);
            j++;
        }

        return res;


    }
}