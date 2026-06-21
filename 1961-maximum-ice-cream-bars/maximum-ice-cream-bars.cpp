class Solution{
public:
    int maxIceCream(vector<int> &c, int coins){
        int n=c.size();

        sort(c.begin(), c.end());
        int i=0;
        while(i<n){
            if(coins>=c[i]){
                coins -= c[i];
            }
            else{
                break;
            }
            i++;
        }   

        return i;

    }
};