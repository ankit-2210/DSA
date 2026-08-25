class Solution{
    public int missingMultiple(int[] nums, int k){
        int n=nums.length;

        HashSet<Integer> st=new HashSet<>();
        for(int num: nums){
            st.add(num);
        }

        int t=k;
        while(true){
            if(!st.contains(t)){
                return t;
            }

            t += k;
        }



    }
}