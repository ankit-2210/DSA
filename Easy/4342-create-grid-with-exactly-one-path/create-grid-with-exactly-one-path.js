/**
 * @param {number} m
 * @param {number} n
 * @return {string[]}
 */
var createGrid = function(n, m) {

    const res=[];
    for(let i=0; i<n; i++){
        let temp="";
        for(let j=0; j<m; j++){
            if(i == 0 || j == m-1){
                temp += '.';
            }
            else{
                temp += '#';
            }
        }

        res.push(temp);
    }

        return res;

};