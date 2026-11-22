/**
 * @param {string} s
 * @return {boolean}
 */
var checkString = function(s) {
    const n=s.length;

    let flag=false;
    for(let i=0; i<n; i++){
        const ch=s[i];
        if(ch == 'a' && flag == true){
            return false;
        }
        else if(ch == 'b'){
            flag=true;
        }
    }

    return true;
};