class Solution{
    final static int mod=1000000007;
    public int numOfSubarrays(int[] arr){
        int n=arr.length;

        int even=0, odd=0;
        int res=0;
        int total=0;
        int i=0;
        while(i<n){
            total += arr[i];
            if(total%2 == 0){
                even++;
                res=(res+odd)%mod;
            }
            else{
                odd++;
                res=(res+even+1)%mod;
            }

            i++;
        }

        return res%mod;
    }
}