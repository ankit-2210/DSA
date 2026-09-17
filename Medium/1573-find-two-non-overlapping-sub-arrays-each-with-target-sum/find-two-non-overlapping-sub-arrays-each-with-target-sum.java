class Solution{
    public int minSumOfLengths(int[] arr, int t){
        int n=arr.length;

        int[] prefix=new int[n];
        int[] suffix=new int[n];

        Arrays.fill(prefix, Integer.MAX_VALUE);
        Arrays.fill(suffix, Integer.MAX_VALUE);

        int temp=Integer.MAX_VALUE;
        int curr=0;
        int i=0;
        for(int j=0; j<n; j++){
            curr += arr[j];
            while(curr>t){
                curr -= arr[i];
                i++;
            }

            if(curr == t){
                temp=Math.min(temp, j-i+1);
            }
            prefix[j]=temp;
        }

        curr=0;
        temp=Integer.MAX_VALUE;
        i=n-1;
        for(int j=n-1; j>=0; j--){
            curr += arr[j];
            while(curr>t){
                curr -= arr[i];
                i--;
            }

            if(curr == t){
                temp=Math.min(temp, i-j+1);
            }
            suffix[j]=temp;
        }

        int res=Integer.MAX_VALUE;
        for(int k=0; k<n-1; k++){
            if(prefix[k] != Integer.MAX_VALUE && suffix[k+1] != Integer.MAX_VALUE){
                res = Math.min(res, prefix[k]+suffix[k+1]);
            }
        }
        
        if(res == Integer.MAX_VALUE)
            return -1;

        return res;



    }
}