class Solution{
public:
    bool solve(int idx, vector<int> &arr, vector<bool> &visited, int n){
        if(idx<0 || idx>=n)
            return false;

        if(arr[idx] == 0)
            return true;

        if(visited[idx])
            return false;

        visited[idx]=true;
        bool left=solve(idx-arr[idx], arr, visited, n);
        bool right=solve(idx+arr[idx], arr, visited, n);
        return left || right;
    }
    
    bool canReach(vector<int> &arr, int start){
        int n=arr.size();

        vector<bool> visited(n);
        return solve(start, arr, visited, n);
    }
};