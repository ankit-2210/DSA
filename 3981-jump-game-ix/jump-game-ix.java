class Solution{
    public int[] maxValue(int[] nums){
        int n=nums.length;

        int[] prefix=new int[n];
        prefix[0]=nums[0];
        for(int i=1; i<n; i++){
            prefix[i]=Math.max(prefix[i-1], nums[i]);
        }

        int suffixmin=nums[n-1];
        int[] res=new int[n];
        res[n-1]=prefix[n-1];
        for(int i=n-2; i>=0; i--){
            if(prefix[i]>suffixmin){
                res[i]=res[i+1];
            }
            else{
                res[i]=prefix[i];
            }
            suffixmin=Math.min(suffixmin, nums[i]);
        }

        return res;
    }
}