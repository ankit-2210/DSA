class Solution{
    public int missingInteger(int[] nums){
        int n=nums.length;

        HashMap<Integer, Integer> mp=new HashMap<>();
        for(int num: nums){
            mp.put(num, mp.getOrDefault(num, 0)+1);
        }

        int sum=nums[0];
        for(int i=1; i<n; i++){
            if(nums[i-1]+1 == nums[i]){
                sum += nums[i];
            }
            else{
                break;
            }
        }

        while(mp.containsKey(sum)){
            sum++;
        }

        return sum;


    }
}