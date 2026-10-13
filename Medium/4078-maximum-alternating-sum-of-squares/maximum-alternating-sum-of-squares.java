class Solution{
    public long maxAlternatingSum(int[] nums){
        int n=nums.length;

        for(int i=0; i<n; i++){
            nums[i]=Math.abs(nums[i]);
        }

        Arrays.sort(nums);
        long res=0;
        for(int i=0; i<n/2; i++){
            res += (nums[n-1-i]*nums[n-1-i]-nums[i]*nums[i]);
        }

        if(n%2 != 0){
            res += (nums[n/2]*nums[n/2]);
        }

        return res;
    }
}