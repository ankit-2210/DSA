class Solution{
    public int minMoves(int[] nums){
        int n=nums.length;

        Arrays.sort(nums);
        int res=0;
        for(int i=1; i<n; i++){
            res += (nums[i]-nums[0]);
        }
        
        return res;
    }
}