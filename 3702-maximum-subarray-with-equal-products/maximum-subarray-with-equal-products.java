class Solution{
    int solve(int a, int b){
        if(b == 0)
            return a;
        
        return solve(b, a%b);
    }

    public int maxLength(int[] nums){
        int n=nums.length;

        int res=2;
        int prod=1;
        int i=0, j=0;
        while(j<n){
            int x=nums[j];
            while(solve(prod, x)>1){
                prod /= nums[i];
                i++;
            }

            prod *= x;
            res=Math.max(res, j-i+1);
            j++;
        }

        return res;
    }
}