class Solution{
    boolean solve(int[] arr2, int num, int d, int m){
        int low=0, high=m-1;
        while(low<=high){
            int mid=low+(high-low)/2;

            if(Math.abs(arr2[mid]-num)<=d)
                return false;

            if(arr2[mid]<num-d){
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }

        return true;
    }

    public int findTheDistanceValue(int[] arr1, int[] arr2, int d){
        int n=arr1.length;
        int m=arr2.length;

        Arrays.sort(arr2);
        int res=0;
        for(int i=0; i<n; i++){
            if(solve(arr2, arr1[i], d, m))
                res++;
        }

        return res;

    }
}