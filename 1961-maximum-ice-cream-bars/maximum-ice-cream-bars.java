class Solution{
    public int maxIceCream(int[] c, int coins){
        int n=c.length;

        Arrays.sort(c);
        int i=0;
        while(i<n){
            if(coins>=c[i]){
                coins -= c[i];
            }
            else{
                break;
            }
            i++;
        }   

        return i;
    }
}