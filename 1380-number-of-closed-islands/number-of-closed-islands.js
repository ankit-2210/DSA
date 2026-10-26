/**
 * @param {number[][]} grid
 * @return {number}
 */
var closedIsland = function(g) {
    const n=g.length;
    const m=g[0].length;

    let res=0

    const solve = (i, j)=>{
    
        const q=[[i, j]]
        g[i][j]=1;

        let flag=true;
        while(q.length>0){
            const [x, y]=q.shift();

            if(x == 0 || x == n-1 || y == 0 || y == m-1)
                flag=false;

            if(x-1>=0 && g[x-1][y] == 0){
                g[x-1][y]=1;
                q.push([x-1, y]);
            }
            if(x+1<n && g[x+1][y] == 0){
                g[x+1][y]=1;
                q.push([x+1, y]);
            }
            if(y-1>=0 && g[x][y-1] == 0){
                g[x][y-1]=1;
                q.push([x, y-1]);
            }
            if(y+1<m && g[x][y+1] == 0){
                g[x][y+1]=1;
                q.push([x, y+1]);
            }
        }

        return flag;

    }

        for(let i=0; i<n; i++){
            for(let j=0; j<m; j++){
                if(g[i][j] == 0){
                    
                    if(solve(i, j)){
                        res++;
                    }
                }
            }
        }

        return res;
    
};