class Solution{
public:
    int countMajoritySubarrays(vector<int> &nums, int t){
        int n=nums.size();

        vector<int> temp(n);
        for(int i=0; i<n; i++){
            if(nums[i] == t){
                temp[i]=1;
            }
            else{
                temp[i]=-1;
            }
        }

        map<int, int> mp;
        mp[0]=1;

        int prefix=0;
        int res=0;
        for(int i=0; i<n; i++){
            prefix += temp[i];

            for(auto it: mp){
                if(it.first<prefix){
                    res += it.second;
                }
            }

            mp[prefix]++;
        }

        return res;


    }
};