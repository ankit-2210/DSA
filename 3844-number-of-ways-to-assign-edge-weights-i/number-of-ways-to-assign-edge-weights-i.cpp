#define ll long long int
#define mod 1000000007

class Solution{
public:
    void solve(int node, int parent, int depth, vector<vector<int>> &adj, int &mx, int &mxNode){
        if(depth>mx){
            mx=depth;
            mxNode=node;
        }

        for(auto it: adj[node]){
            if(it != parent){
                solve(it, node, depth+1, adj, mx, mxNode);
            }
        }
    }

    int power(ll a, ll b){
        ll p=1;
        while(b>0){
            if(b%2){
                p=(p*a)%mod;
            }
            a=(a*a)%mod;
            b/=2;
        }

        return p;
    }


    int assignEdgeWeights(vector<vector<int>> &e){
        int n=e.size();

        vector<vector<int>> adj(100001);
        for(auto it: e){
            adj[it[0]].push_back(it[1]);
            adj[it[1]].push_back(it[0]);
        }

        int mxNode=0;
        int mx=0;
        solve(1, 0, 0, adj, mx, mxNode);

        // cout << mx << " " << mxNode << endl;

        return power(2, mx-1);


    }
};