class Solution{
public:
    vector<int> pivotArray(vector<int> &nums, int p){
        int n=nums.size();

        vector<int> res(n);
        int i=0, j=n-1;
        int low=0, high=n-1;
        while(i<n){
            if(nums[i]<p){
                res[low++]=nums[i];
            }
            if(nums[j]>p){
                res[high--]=nums[j];
            }
            i++;
            j--;
        }

        while(low<=high){
            res[low++]=p;
        }

        return res;

        


    }
};