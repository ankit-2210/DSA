class Solution{
public:
    int solve(int num){
        string s=to_string(num);
        int n=s.size();
        if(n<3)
            return 0;

        int res=0;
        for(int i=1; i<n-1; i++){
            if(s[i]>s[i-1] && s[i]>s[i+1])
                res += 1;
            else if(s[i]<s[i-1] && s[i]<s[i+1])
                res += 1;
        }

        return res;
    }

    int totalWaviness(int num1, int num2){
        int res=0;
        for(int i=num1; i<=num2; i++){
            res += solve(i);
        }

        return res;

    }
};