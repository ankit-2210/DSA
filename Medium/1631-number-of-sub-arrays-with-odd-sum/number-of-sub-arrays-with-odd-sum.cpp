#define ll long long int
#define mod 1000000007

class Solution{
public:
    int numOfSubarrays(vector<int> &arr) {
        int n=arr.size();

        int even=0, odd=0;
        int res=0;
        int total=0;
        int i=0;
        while(i<n){
            total += arr[i];
            if(total%2 == 0){
                even++;
                res=(res+odd)%mod;
            }
            else{
                odd++;
                res=(res+even+1)%mod;
            }

            i++;
        }

        return res%mod;
    }
};