class Solution{
    public int minOperations(int[] nums, int x){
        int n=nums.length;

        int sum=Arrays.stream(nums).sum();
        int t=sum-x;

        if(t == 0)
            return n;
        
        if(t<0)
            return -1;

        int mx=0;
        int total=0;
        int i=0, j=0;
        while(j<n){
            total += nums[j];

            while(total>t){
                total -= nums[i];
                i++;
            }

            if(total == t){
                mx=Math.max(mx, j-i+1);
            }

            j++;
        }

        if(mx == 0)
            return -1;

        return n-mx;

    }
}