class Solution{
    int solve(int num){
        String s = String.valueOf(num);
        int n=s.length();
        if(n<3)
            return 0;

        int res=0;
        for(int i=1; i<n-1; i++){
            if(s.charAt(i)>s.charAt(i-1) && s.charAt(i)>s.charAt(i+1))
                res += 1;
            else if(s.charAt(i)<s.charAt(i-1) && s.charAt(i)<s.charAt(i+1))
                res += 1;
        }

        return res;
    }
    
    public int totalWaviness(int num1, int num2) {
        int res=0;
        for(int i=num1; i<=num2; i++){
            res += solve(i);
        }

        return res;
    }
}