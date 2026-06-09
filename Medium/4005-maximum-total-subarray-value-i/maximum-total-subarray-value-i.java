import java.util.*;

class Solution{
    public long maxTotalValue(int[] nums, int k){
        // long mx=Arrays.stream(nums).max().getAsInt();
        // long mn=Arrays.stream(nums).min().getAsInt();

        // return (mx-mn)*(long)k;

        IntSummaryStatistics stats = Arrays.stream(nums)
                                           .summaryStatistics();
        return (stats.getMax()-stats.getMin())*(long)k;
    }
}