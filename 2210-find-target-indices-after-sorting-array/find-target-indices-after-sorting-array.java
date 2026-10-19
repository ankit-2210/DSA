class Solution{
    public List<Integer> targetIndices(int[] nums, int t){
        int n=nums.length;

        List<Integer> res=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<n; i++){
            if(nums[i] == t){
                res.add(i);
            }
        }   

        return res;
    }
}