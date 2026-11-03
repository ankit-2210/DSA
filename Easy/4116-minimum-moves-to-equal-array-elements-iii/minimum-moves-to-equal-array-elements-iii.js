/**
 * @param {number[]} nums
 * @return {number}
 */
var minMoves = function(nums) {
    const n=nums.length;

    let res=0;
    nums.sort((a, b)=>a-b);
    for(let i=0; i<n; i++){
        res += (nums[n-1]-nums[i]);
    }

    return res;
    
};