class Solution{
    public int longestMonotonicSubarray(int[] nums){
        int n=nums.length;

        int mx=1;
        int[] inc=new int[n];
        Arrays.fill(inc, 1);
        for(int i=1; i<n; i++){
            if(nums[i-1]<nums[i]){
                inc[i]=1+inc[i-1];
            }
            mx=Math.max(mx, inc[i]);
        }

        int[] dec=new int[n];
        Arrays.fill(dec, 1);
        for(int i=n-2; i>=0; i--){
            if(nums[i+1]<nums[i]){
                dec[i]=1+dec[i+1];
            }
            mx=Math.max(mx, dec[i]);
        }

        return mx;

    }
}