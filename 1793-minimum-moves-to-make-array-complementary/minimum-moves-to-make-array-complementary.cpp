class Solution{
public:
    int minMoves(vector<int> &nums, int l){
        int n=nums.size();

        vector<int> diff(2*l+2, 0);
        for(int i=0; i<n/2; i++){
            int a=nums[i];
            int b=nums[n-i-1];
            int sum=a+b;

            int low=min(a, b)+1;
            int high=max(a, b)+l;

            diff[2]+=2;
            diff[2*l+1]-=2;

            diff[low]-=1;
            diff[high+1]+=1;

            diff[sum]-=1;
            diff[sum+1]+=1;
        }

        int sum=0;
        int res=INT_MAX;
        for(int i=2; i<=2*l; i++){
            sum += diff[i];
            res=min(res, sum);
        }

        return res;
    }
};