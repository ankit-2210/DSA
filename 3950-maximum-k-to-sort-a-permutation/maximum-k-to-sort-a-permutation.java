class Solution{
    public int sortPermutation(int[] nums){
        int n=nums.length;

        int bit=-1;
        for(int i=0; i<n; i++){
            if(nums[i] != i){
                if(bit == -1){
                    bit=nums[i];
                }
                else{
                    bit&=nums[i];
                }
            }
        }
        
        if(bit == -1)
            return 0;
            
        return bit;

    }
}