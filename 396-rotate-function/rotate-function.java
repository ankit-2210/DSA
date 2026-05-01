class Solution{
    public int maxRotateFunction(int[] nums){
        int n=nums.length;

        int sum=0;
        int f=0;
        for(int i=0; i<n; i++){
            f += (i*nums[i]);
            sum += nums[i];
        }

        int res=f;
        int i=n-1;
        while(i>0){
            f=f+sum-(n*nums[i]);
            res=Math.max(res, f);
            i--;
        }

        return res;
    }
}