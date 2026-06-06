class Solution{
public:
    bool hasValidPath(vector<vector<int>> &g){
        int n=g.size();
        int m=g[0].size();

        vector<vector<pair<int, int>>> v={{},{{0, -1}, {0, 1}}, {{-1, 0}, {1, 0}}, {{0, -1}, {1, 0}}, {{0, 1}, {1, 0}}, {{0, -1}, {-1, 0}}, {{0, 1}, {-1, 0}}};

        vector<vector<bool>> visited(n, vector<bool> (m, false));
        queue<pair<int, int>> q;
        q.push({0, 0});
        visited[0][0]=true;
        while(!q.empty()){
            int i=q.front().first;
            int j=q.front().second;
            q.pop();

            if(i == n-1 && j == m-1)
                return true;

            for(auto it: v[g[i][j]]){
                int x=it.first;
                int y=it.second;
                int nx=i+x;
                int ny=j+y;
                if(nx<0 || nx>=n || ny<0 || ny>=m || visited[nx][ny] == true)
                    continue;
               
                bool flag=false;
                for(auto it1: v[g[nx][ny]]){
                    int dx=it1.first;
                    int dy=it1.second;
                    if(dx == -x && dy == -y){
                        flag=true;
                        break;
                    }
                }

                if(flag == true){
                    visited[nx][ny]=true;
                    q.push({nx, ny});
                }
            }
        }

        return false;

    }
};