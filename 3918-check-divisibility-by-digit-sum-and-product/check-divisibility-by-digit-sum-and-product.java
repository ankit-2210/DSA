class Solution{
    boolean solve(int n){
        int temp=n;
        int sum=0;
        int prod=1;

        while(n>0){
            int rem=n%10;
            n/=10;
            sum += rem;
            prod *= rem;
        }

        int total=sum+prod;
        if(temp%total == 0)
            return true;
        
        return false;
    }

    public boolean checkDivisibility(int n){
        
        return solve(n);


    }
}