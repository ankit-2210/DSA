#define ll long long int

class Solution{
public:
    long long maxTotalValue(vector<int> &nums, int k){
        int n=nums.size();

        ll mx=*max_element(nums.begin(), nums.end());
        ll mn=*min_element(nums.begin(), nums.end());

        // cout << mx << " " << mn << endl;

        return (mx-mn)*(ll)k;


    }
};