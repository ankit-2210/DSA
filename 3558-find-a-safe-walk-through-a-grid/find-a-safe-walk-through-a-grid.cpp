class Solution{
public:
    bool findSafeWalk(vector<vector<int>> &g, int h){
        int n=g.size();
        int m=g[0].size();

        priority_queue<pair<int, pair<int, int>>> pq;
        h -= g[0][0];
        if(h<1)
            return false;

        vector<vector<int>> dist(n, vector<int> (m, -1));
        pq.push({h, {0, 0}});
        dist[0][0]=h;
        while(!pq.empty()){
            int x=pq.top().first;
            int i=pq.top().second.first;
            int j=pq.top().second.second;
            pq.pop();

            if(x<dist[i][j])
                continue;

            if(i == n-1 && j == m-1)
                return true;

            if(i-1>=0){
                int newh=x-g[i-1][j];
                if(newh>=1 && newh>dist[i-1][j]){
                    dist[i-1][j]=newh;
                    pq.push({newh, {i-1, j}});
                }
            }
            if(i+1<n){
                int newh=x-g[i+1][j];
                if(newh>=1 && newh>dist[i+1][j]){
                    dist[i+1][j]=newh;
                    pq.push({newh, {i+1, j}});
                }
            }
            if(j-1>=0){
                int newh=x-g[i][j-1];
                if(newh>=1 && newh>dist[i][j-1]){
                    dist[i][j-1]=newh;
                    pq.push({newh, {i, j-1}});
                }
            }
            if(j+1<m){
                int newh=x-g[i][j+1];
                if(newh>=1 && newh>dist[i][j+1]){
                    dist[i][j+1]=newh;
                    pq.push({newh, {i, j+1}});
                }
            }
        }

        return false;
    }
};