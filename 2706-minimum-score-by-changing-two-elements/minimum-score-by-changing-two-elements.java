class Solution{
    public int minimizeSum(int[] nums){
        int n=nums.length;
        if(n<=3)
            return 0;

        int mx=Arrays.stream(nums).max().getAsInt();  
        int mn=Arrays.stream(nums).min().getAsInt();
        int firstmn=Integer.MAX_VALUE, secondmn=Integer.MAX_VALUE, thirdmn=Integer.MAX_VALUE;
        int firstmx=0, secondmx=0, thirdmx=0;
        for(int i=0; i<n; i++){
            if(nums[i]<firstmn){
                thirdmn=secondmn;
                secondmn=firstmn;
                firstmn=nums[i];
            }
            else if(nums[i]<secondmn){
                thirdmn=secondmn;
                secondmn=nums[i];
            }
            else if(nums[i]<thirdmn){
                thirdmn=nums[i];
            }

            if(nums[i]>firstmx){
                thirdmx=secondmx;
                secondmx=firstmx;
                firstmx=nums[i];
            }
            else if(nums[i]>secondmx){
                thirdmx=secondmx;
                secondmx=nums[i];
            }
            else if(nums[i]>thirdmx){
                thirdmx=nums[i];
            }
        }

        return Math.min(firstmx-thirdmn, Math.min(thirdmx-firstmn, secondmx-secondmn));

    }
}