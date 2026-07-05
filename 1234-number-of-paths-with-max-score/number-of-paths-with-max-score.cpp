#define ll long long int
#define mod 1000000007

class Solution {
public:
    void solve(int i, int j, vector<string> &b, vector<vector<int>> &score, vector<vector<int>> &ways, vector<vector<bool>> &visited, int n, int m){
        if(i<0 || j<0 || b[i][j] == 'X')
            return;

        if(visited[i][j] == true)
            return;

        visited[i][j]=true;
        if(i == 0 && j == 0){
            score[0][0]=0;
            ways[0][0]=1;
            return;
        }

        solve(i-1, j, b, score, ways, visited, n, m);
        solve(i, j-1, b, score, ways, visited, n, m);
        solve(i-1, j-1, b, score, ways, visited, n, m);

        int best=INT_MIN;
        if(i-1>=0){
            best=max(best, score[i-1][j]);
        }
        if(j-1>=0){
            best=max(best, score[i][j-1]);
        }
        if(i-1>=0 && j-1>=0){
            best=max(best, score[i-1][j-1]);
        }

        if(best == INT_MIN){
            score[i][j]=INT_MIN;
            ways[i][j]=0;
            return;
        }

        ll count=0;
        if(i-1>=0 && score[i-1][j] == best){
            count += ways[i-1][j];
        }
        if(j-1>=0 && score[i][j-1] == best){
            count += ways[i][j-1];
        }
        if(i-1>=0 && j-1>=0 && score[i-1][j-1] == best){
            count += ways[i-1][j-1];
        }

        count%=mod;

        char ch=b[i][j];
        int val=(ch == 'E' || ch == 'S')?0:ch-'0';

        score[i][j]=best+val;
        ways[i][j]=(int)count;
    }

    vector<int> pathsWithMaxScore(vector<string> &b){
        int n=b.size();
        int m=b[0].size();

        vector<vector<int>> score(n, vector<int> (m));
        vector<vector<int>> ways(n, vector<int> (m));
        vector<vector<bool>> visited(n, vector<bool> (m));

        solve(n-1, m-1, b, score, ways, visited, n, m);

        if(ways[n-1][m-1] == 0)
            return {0, 0};


        return {score[n-1][m-1], ways[n-1][m-1]};
    }
};