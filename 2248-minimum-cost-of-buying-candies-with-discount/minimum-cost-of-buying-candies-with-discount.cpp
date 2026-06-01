class Solution{
public:
    int minimumCost(vector<int> &c){
        int n=c.size();

        sort(c.rbegin(), c.rend());
        int sum=0;
        int i=0;
        while(i<n){
            sum += c[i];
            if(i+1<n){
                sum += c[i+1];
            }

            i+=3;
        }

        return sum;

    }
};