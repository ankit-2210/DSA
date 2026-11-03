class Solution{
    public int minMoves(int[] nums){
        int n=nums.length;

        int res=0;
        Arrays.sort(nums);
        for(int i=0; i<n; i++){
            res += (nums[n-1]-nums[i]);
        }

        return res;

    }
}