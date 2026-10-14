class Solution{
    public String maxSumOfSquares(int num, int sum){
        if(sum>9*num)
            return "";

        int qt=sum/9;
        int rem=sum%9;

        StringBuilder str=new StringBuilder();
        for(int i=0; i<qt; i++){
            str.append('9');
        }
        if(rem>0){
            str.append((char)(rem+'0'));
        }

        for(int i=qt+(rem>0?1:0); i<num; i++){
            str.append('0');
        }

        return str.toString();
    }
}