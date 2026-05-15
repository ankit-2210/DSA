class Solution{
public:
    vector<int> maxValue(vector<int> &nums){
        int n=nums.size();

        vector<int> prefix(n);
        prefix[0]=nums[0];
        for(int i=1; i<n; i++){
            prefix[i]=max(prefix[i-1], nums[i]);
        }

        int suffixmin=nums[n-1];
        vector<int> res(n);
        res[n-1]=prefix[n-1];
        for(int i=n-2; i>=0; i--){
            if(prefix[i]>suffixmin){
                res[i]=res[i+1];
            }
            else{
                res[i]=prefix[i];
            }
            suffixmin=min(suffixmin, nums[i]);
        }

        return res;

    }
};