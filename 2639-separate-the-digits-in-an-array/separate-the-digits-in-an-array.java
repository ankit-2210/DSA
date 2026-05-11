class Solution{
    public int[] separateDigits(int[] nums){
        int n=nums.length;

        StringBuilder str=new StringBuilder();
        for(int i=0; i<n; i++){
            str.append(nums[i]);
        } 

        int[] res=new int[str.length()];
        for(int i=0; i<str.length(); i++){
            res[i]=str.charAt(i)-'0';
        }

        return res;
    }
}