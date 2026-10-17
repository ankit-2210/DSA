class Solution{
    static int solve(int num){
        int sum=0;
        while(num>0){
            sum += (num%10);
            num/=10;
        }

        return sum;
    }

    public int minSwaps(int[] nums){
        int n=nums.length;

        int[][] v=new int[n][2];
        for(int i=0; i<n; i++){
            v[i][0]=nums[i];
            v[i][1]=i;
        }

        Arrays.sort(v, (a, b)->{
            int s1=solve(a[0]);
            int s2=solve(b[0]);

            if(s1 != s2)
                return Integer.compare(s1, s2);

            if(a[0] != b[0])
                return Integer.compare(a[0], b[0]);

            return Integer.compare(a[1], b[1]);
        });

        int[] pos=new int[n];
        for(int i=0; i<n; i++){
            pos[v[i][1]]=i;
        }

        boolean[] visited=new boolean[n];
        int res=0;
        for(int i=0; i<n; i++){
            if(visited[i] || pos[i] == i)
                continue;

            int c=0;
            int j=i;
            while(!visited[j]){
                visited[j]=true;
                j=pos[j];
                c++;
            }

            res += (c-1);
        }

        return res;

    }
}

// Time: O(nlogn) for sorting + O(n) for cycle detection 
// Space: O(n) for pairs, position array and visited array

