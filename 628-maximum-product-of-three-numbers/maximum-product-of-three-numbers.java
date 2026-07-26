class Solution{
    public int maximumProduct(int[] nums){
        int n=nums.length;

        int mx1=Integer.MIN_VALUE, mx2=Integer.MIN_VALUE, mx3=Integer.MIN_VALUE;
        int mn1=Integer.MAX_VALUE, mn2=Integer.MAX_VALUE;
        for(int num: nums){
            if(num>=mx1){
                mx3=mx2;
                mx2=mx1;
                mx1=num;
            }
            else if(num>=mx2){
                mx3=mx2;
                mx2=num;
            }
            else if(num>=mx3){
                mx3=num;
            }

            if(num<=mn1){
                mn2=mn1;
                mn1=num;
            }
            else if(num<=mn2){
                mn2=num;
            }
        }

        int prod1=mx1*mx2*mx3;
        int prod2=mn1*mn2*mx1;

        return Math.max(prod1, prod2);
    }
}