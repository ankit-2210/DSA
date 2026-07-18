class Solution{
    int solve(int a, int b){
        if(b == 0)
            return a;
        return solve(b, a%b);
    }

    public int findGCD(int[] nums){
        int n=nums.length;

        var stats = Arrays.stream(nums).summaryStatistics();
        return solve(stats.getMax(), stats.getMin());


    }
}