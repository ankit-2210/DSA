class Solution{
public:
    int digitFrequencyScore(int n){

        map<int, int> mp;
        while(n>0){
            int rem=n%10;
            n/=10;
            mp[rem]++;
        }

        int sum=0;
        for(auto it: mp){
            sum += (it.first*it.second);
        }

        return sum;
        
    }
};