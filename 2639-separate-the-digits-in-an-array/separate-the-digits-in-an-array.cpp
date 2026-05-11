class Solution{
public:
    vector<int> separateDigits(vector<int> &nums){
        int n=nums.size();

        string str="";
        for(int i=0; i<n; i++){
            str += to_string(nums[i]);
        } 

        vector<int> res;
        for(auto it: str){
            res.push_back(it-'0');
        }

        return res;

    }
};