class Solution{
    public int minimumSumSubarray(List<Integer> nums, int l, int r){
        int n=nums.size();

        int res=Integer.MAX_VALUE;
        for(int k=l; k<=r; k++){
            int curr=0;
            int i=0, j=0;
            while(j<n){
                curr += nums.get(j);
                while(j-i+1 == k){
                    if(curr>0){
                        res=Math.min(res, curr);
                    }
                    curr -= nums.get(i);
                    i++;
                }

                j++;
            }
        }

        if(res == Integer.MAX_VALUE)
            return -1;
            
        return res;

    }
}