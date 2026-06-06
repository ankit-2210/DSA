class Solution{
    public char[][] rotateTheBox(char[][] b){
        int n=b.length;
        int m=b[0].length;

        char[][] dp=new char[m][n];
        for(char[] ch: dp){
            Arrays.fill(ch, '.');
        }
        for(int r=0; r<n; r++){
            int i=m-1;
            for(int c=m-1; c>=0; c--){
                if(b[r][c] == '#'){
                    dp[i][n-r-1]='#';
                    i--;
                }
                else if(b[r][c] == '*'){
                    dp[c][n-r-1]='*';
                    i=c-1;
                }
            }
        }

        return dp;
    }
}