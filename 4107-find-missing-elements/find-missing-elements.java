class Solution{
    public List<Integer> findMissingElements(int[] nums){
        int n=nums.length;

        HashMap<Integer, Integer> mp=new HashMap<>();
        for(int num: nums){
            mp.put(num, mp.getOrDefault(num, 0)+1);
        }

        int mx=Arrays.stream(nums)
                    .max()
                    .getAsInt();

        int mn=Arrays.stream(nums)
                    .min()
                    .getAsInt();

        List<Integer> res=new ArrayList<>();
        int i=mn;
        while(i<=mx){
            if(!mp.containsKey(i)){
                res.add(i);
            }
            i++;
        }

        return res;

    }
}