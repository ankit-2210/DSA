#define ll long long int

class Solution{
public:
    bool solve(vector<vector<pair<ll, ll>>> &adj, ll mid, ll k, int n){
        vector<ll> dist(n, k+1);
        priority_queue<pair<ll, ll>, vector<pair<ll, ll>>, greater<pair<ll, ll>> > pq;
        dist[0]=0;
        pq.push({0, 0});

        while(!pq.empty()){
            ll cost=pq.top().first;
            ll node=pq.top().second;
            pq.pop();

            if(cost>dist[node])
                continue;

            if(node == n-1)
                return true;

            for(auto it: adj[node]){
                if(it.second<mid)
                    continue;
                if(cost+it.second<dist[it.first]){
                    dist[it.first]=it.second+cost;
                    pq.push({dist[it.first], it.first});
                }
            }

        }

        return false;


    }

    int findMaxPathScore(vector<vector<int>> &e, vector<bool> &online, long long k){
        int n=online.size();

        vector<vector<pair<ll, ll>>> adj(n);
        ll low=0, high=0;
        for(auto it: e){
            high=max(high, (ll)it[2]);
            if(online[it[0]] == false || online[it[1]] ==  false)
                continue;
            adj[it[0]].push_back({it[1], it[2]});
        }

        ll res=-1;
        while(low<=high){
            ll mid=low+(high-low)/2;
            if(solve(adj, mid, k, n)){
                res=mid;
                low=mid+1;
            }
            else{
                high=mid-1;
            }
        }

        return res;

    }
};