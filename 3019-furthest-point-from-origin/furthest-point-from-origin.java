class Solution{
    public int furthestDistanceFromOrigin(String m){
        int n=m.length();

        int left=0, right=0, count=0;
        for(int i=0; i<n; i++){
            if(m.charAt(i) == 'L'){
                left++;
            }
            else if(m.charAt(i) == 'R'){
                right++;
            }
            else{
                count++;
            }
        }

        if(left>=right)
            return left+count-right;

        return right+count-left;
    }
}