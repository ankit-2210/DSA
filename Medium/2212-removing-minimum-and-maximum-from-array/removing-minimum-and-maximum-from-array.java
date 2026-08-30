import java.util.stream.IntStream;

class Solution{
    public int minimumDeletions(int[] nums){
        int n=nums.length;

        int mxIndex=IntStream.range(0, n)
                            .reduce((i, j) -> nums[i]>=nums[j] ? i : j)
                            .orElse(-1);
        
        int mnIndex=IntStream.range(0, n)
                            .reduce((i, j) -> nums[i]<=nums[j] ? i : j)
                            .orElse(-1);

        System.out.println(mxIndex + " " + mnIndex);
        int mx=Math.max(mxIndex, mnIndex);
        int mn=Math.min(mxIndex, mnIndex);

        return Math.min(Math.min(mx+1, n-mn), mn+(n-mx)+1);



    }
}