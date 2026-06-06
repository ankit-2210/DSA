class Solution{
public:
    bool isGood(vector<int> &nums){
        int n=nums.size();

        int mx=*max_element(nums.begin(), nums.end());
        map<int, int> mp;
        for(int i=0; i<n; i++){
            mp[nums[i]]++;
        }
        for(int i=1; i<mx; i++){
            if(mp[i] != 1)
                return false;
        }

        if(mp[mx] != 2)
            return false;

        return true;
    }
};