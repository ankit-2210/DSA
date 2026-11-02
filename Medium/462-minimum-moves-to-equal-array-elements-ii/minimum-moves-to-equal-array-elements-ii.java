class Solution{
    public int minMoves2(int[] nums){
        int n=nums.length;

        Arrays.sort(nums);

        int res=0;
        int i=0, j=n-1;
        while(i<=j){
            res += Math.abs(nums[j]-nums[i]);
            i++;
            j--;
        }

        return res;


    }
}