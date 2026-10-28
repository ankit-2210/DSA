/**
 * @param {number[][]} grid
 * @param {number} k
 * @return {number}
 */
var countIslands = function(g, k) {
    const n=g.length;
    const m=g[0].length;

    let  res=0;
    const visited=Array.from({length: n}, () => new Array(m).fill(false));
        
    function solve(i, j, sumObj){
        if(i<0 || i>=n || j<0 || j>=m || visited[i][j] == true || g[i][j]<=0)
            return;

        sumObj.value += g[i][j];
        visited[i][j]=true;

        solve(i+1, j, sumObj);
        solve(i-1, j, sumObj);
        solve(i, j+1, sumObj);
        solve(i, j-1, sumObj);

    }
        
    for(let i=0; i<n; i++){
        for(let j=0; j<m; j++){
            if(g[i][j]>0 && !visited[i][j]){
                const sumObj={value: 0};
                solve(i, j, sumObj);

                if(sumObj.value%k == 0){
                    res++;
                }
            }
        }
    }

    return res;
};