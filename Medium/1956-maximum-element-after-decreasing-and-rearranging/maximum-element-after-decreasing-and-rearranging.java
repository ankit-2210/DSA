class Solution{
    public int maximumElementAfterDecrementingAndRearranging(int[] arr){
        int n=arr.length;

        Arrays.sort(arr);
        arr[0]=1;
        int res=0;
        int i=1;
        while(i<n){ 
            if(arr[i]-arr[i-1]>1){
                arr[i]=arr[i-1]+1;
            }
            i++;    
        }

        return arr[n-1];

    }
}