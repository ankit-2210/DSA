class Solution{
public:
    void solve(vector<vector<int>> &e, int s, int t, vector<bool> &visited, int &high, int n){
        vector<vector<int>> adj(n);
        for(auto it: e){
            adj[it[0]].push_back(it[1]);
            adj[it[1]].push_back(it[0]);
            high=max(high, it[2]);
        }
        
        queue<int> q;
        q.push(s);
        visited[s]=true;
        while(!q.empty()){
            int t=q.front();
            q.pop();
            for(auto it: adj[t]){
                if(visited[it] == false){
                    q.push(it);
                    visited[it]=true;
                }
            }
        }
    }

    bool solve1(vector<vector<int>> &e, int s, int t, int k, int mid, int n){
        vector<vector<pair<int, int>>> adj(n);
        for(auto it: e){
            int c=(it[2]>mid?1:0);
            adj[it[0]].push_back({it[1], c});
            adj[it[1]].push_back({it[0], c});
        }

        deque<int> dq;
        vector<int> dist(n, INT_MAX);
        dist[s]=0;
        dq.push_back(s);
        while(!dq.empty()){
            int u=dq.front();
            dq.pop_front();

            for(auto it: adj[u]){
                if(it.second+dist[u]<dist[it.first]){
                    dist[it.first]=it.second+dist[u];
                    if(it.second == 0){
                        dq.push_front(it.first);
                    }
                    else{
                        dq.push_back(it.first);
                    }
                }
            }
        }

        if(dist[t]<=k)
            return true;
        return false;
    }
    
    int minimumThreshold(int n, vector<vector<int>> &e, int s, int t, int k){
        if(s == t)
            return 0;

        int low=0, high=0;
        vector<bool> visited(n, false);
        solve(e, s, t, visited, high, n);
        if(visited[t] == false)
            return -1;

        int res=high;
        while(low<=high){
            int mid=low+(high-low)/2;
            if(solve1(e, s, t, k, mid, n)){
                res=mid;
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }

        return res;
        
    }
};








