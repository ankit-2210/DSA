class Solution{
    public boolean uniformArray(int[] nums){
        int n=nums.length;

        int even=0, odd=0;
        for(int i=0; i<n; i++){
            if(nums[i]%2 == 0){
                even += 1;
            }
            else{
                odd += 1;
            }
        }

        if(even == n || odd == n)
            return true;

        boolean e=(odd>=2)?true:false;
        boolean o=(even>=1 && odd>=1)?true:false;

        return e || o;

    }
}