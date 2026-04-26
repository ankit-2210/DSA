class Solution{
public:
    bool solve(int i, int j, vector<vector<bool>> &visited, vector<vector<char>> &g, int n, int m){
        queue<pair<pair<int, int>, pair<int, int>>> q;
        q.push({{i, j}, {-1, -1}});
        visited[i][j]=true;
        while(!q.empty()){
            int x=q.front().first.first;
            int y=q.front().first.second;
            int px=q.front().second.first;
            int py=q.front().second.second;
            q.pop();

            if(x-1>=0 && g[x-1][y] == g[x][y]){
                if(visited[x-1][y] == false){
                    visited[x-1][y]=true;
                    q.push({{x-1, y}, {x, y}});
                }
                else if(x-1 != px || y != py)
                    return true;
            }
            if(x+1<n && g[x+1][y] == g[x][y]){
                if(visited[x+1][y] == false){
                    visited[x+1][y]=true;
                    q.push({{x+1, y}, {x, y}});
                }
                else if(x+1 != px || y != py)
                    return true;
            }
            if(y-1>=0 && g[x][y-1] == g[x][y]){
                if(visited[x][y-1] == false){
                    visited[x][y-1]=true;
                    q.push({{x, y-1}, {x, y}});
                }
                else if(x != px || y-1 != py)
                    return true;
            }
            if(y+1<m && g[x][y+1] == g[x][y]){
                if(visited[x][y+1] == false){
                    visited[x][y+1]=true;
                    q.push({{x, y+1}, {x, y}});
                }
                else if(x != px || y+1 != py)
                    return true;
            }
        }

        return false;
    }

    bool containsCycle(vector<vector<char>> &g){
        int n=g.size();
        int m=g[0].size();

        vector<vector<bool>> visited(n, vector<bool> (m, false));
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(visited[i][j] == false){
                    if(solve(i, j, visited, g, n, m))
                        return true;
                }
            }
        }

        return false;

    }
};