class Solution{
public:
    int maxRotateFunction(vector<int> &nums){
        int n=nums.size();

        int sum=0;
        int f=0;
        for(int i=0; i<n; i++){
            f += (i*nums[i]);
            sum += nums[i];
        }

        int res=f;
        int i=n-1;
        while(i>0){
            f=f+sum-(n*nums[i]);
            res=max(res, f);
            i--;
        }

        return res;

        // F(0)=0A+1B+2C+3D;
        // F(1)=0D+1A+2B+3C;

        // F(1)-F(0)=1A+1B+1C-3D;
        // F(1)-F(0)=1A+1B+1C+1D-4D;
        // F(1)-F(0)=sum-4D;
        // F(1)=F(0)+sum-4D;          


    }
};