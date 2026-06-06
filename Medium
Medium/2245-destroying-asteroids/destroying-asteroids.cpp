#define ll long long int

class Solution{
public:
    bool asteroidsDestroyed(int m, vector<int> &a){
        int n=a.size();

        ll ms=m;
        sort(a.begin(), a.end());
        for(int i=0; i<n; i++){
            if(ms<a[i])
                return false;

            ms += a[i];
        }

        return true;

    }
};