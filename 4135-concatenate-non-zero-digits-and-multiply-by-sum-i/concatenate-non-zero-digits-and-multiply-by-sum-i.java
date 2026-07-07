class Solution{
    public long sumAndMultiply(int n){

        long sum=0;
        long num=0;
        long mul=1;
        while(n>0){
            int rem=n%10;
            n /= 10;

            if(rem != 0){
                num=rem*mul+num;
                sum += rem;
                mul *= 10;
            }
        }


        return sum*num;

    }
}