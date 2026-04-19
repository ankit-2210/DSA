class Solution{
    public int maxDistance(int[] nums1, int[] nums2){
        int n=nums1.length;
        int m=nums2.length;

        int res=0;
        for(int i=0; i<n; i++){
            int low=i, high=m-1;
            while(low<=high){
                int mid=low+(high-low)/2;
                if(nums1[i]<=nums2[mid]){
                    res=Math.max(res, mid-i);
                    low=mid+1;
                }
                else{
                    high=mid-1;
                }
            }
        }

        return res;
    }
}