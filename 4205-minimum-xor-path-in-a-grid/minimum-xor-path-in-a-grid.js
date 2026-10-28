/**
 * @param {number[][]} grid
 * @return {number}
 */
var minCost = function(g){
    const n=g.length;
    const m=g[0].length;

    const dp=Array.from({length: n}, ()=>
        Array.from({length: m}, () => 
            new Array(1024).fill(-1)
        )
    );

    const solve = (i, j, x) => {
        if(i<0 || i>=n || j<0 || j>=m)
            return Number.MAX_SAFE_INTEGER;

        x ^= g[i][j];
        if(i == n-1 && j == m-1)
            return x;
            
        if(dp[i][j][x] != -1)
            return dp[i][j][x];

        const right=solve(i, j+1, x);
        const down=solve(i+1, j, x);

        dp[i][j][x]=Math.min(right, down);
        return dp[i][j][x];
    };

    return solve(0, 0, 0);


};