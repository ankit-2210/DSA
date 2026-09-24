class Solution{
    boolean solve(int idx, int num){
        int sum=0;
        while(num>0){
            int rem=num%10;
            num/=10;
            sum += rem;
        }

        if(idx == sum)
            return true;
        return false;
    }

    public int smallestIndex(int[] nums){
        int n=nums.length;

        for(int i=0; i<n; i++){
            if(solve(i, nums[i]))
                return i;
        }

        return -1;
    }
}