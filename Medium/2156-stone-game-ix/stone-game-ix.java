class Solution{
    public boolean stoneGameIX(int[] s){
        int n=s.length;

        int[] count=new int[3];
        for(int i=0; i<n; i++){
            int rem=s[i]%3;
            count[rem]++;
        }

        if(count[0]%2 == 0){
            if(count[1]>0 && count[2]>0)
                return true;
            else
                return false;
        }
        
        if(Math.abs(count[1]-count[2])>2)
            return true;

        return false;
    }
}