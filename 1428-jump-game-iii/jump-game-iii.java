class Solution{
    boolean solve(int idx, int[] arr, boolean[] visited, int n){
        if(idx<0 || idx>=n)
            return false;

        if(arr[idx] == 0)
            return true;

        if(visited[idx])
            return false;

        visited[idx]=true;
        boolean left=solve(idx-arr[idx], arr, visited, n);
        boolean right=solve(idx+arr[idx], arr, visited, n);
        return left || right;
    }

    public boolean canReach(int[] arr, int start){
        int n=arr.length;

        boolean[] visited=new boolean[n];
        return solve(start, arr, visited, n);

    }
}