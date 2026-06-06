#define ll long long int

class Solution{
public:
    vector<long long> distance(vector<int> &nums){
        int n=nums.size();

        map<ll, vector<ll>> mp;
        for(int i=0; i<n; i++){
            mp[nums[i]].push_back(i);
        }        

        vector<ll> res(n, 0);
        for(auto it: mp){
            vector<ll> idx=it.second;
            int k=idx.size();
            if(k == 1)
                continue;
            vector<ll> prefix(k);
            prefix[0]=idx[0];
            for(int i=1; i<k; i++){
                prefix[i]=prefix[i-1]+idx[i];
            }

            for(int i=0; i<k; i++){
                ll left=0, right=0;
                if(i>0){
                    left=((ll)i*idx[i])-prefix[i-1];
                }
                if(i<k-1){
                    right=(prefix[k-1]-prefix[i])-((ll)(k-i-1)*idx[i]);
                }
                res[idx[i]]=left+right;
            }
        }

        return res;

    }
};