/**
 * @param {number[]} nums
 * @return {number}
 */
var minMoves = function(nums) {
    const n=nums.length;

    nums.sort((a, b) => a - b);
    let res=0;
    for(let i=1; i<n; i++){
        res += (nums[i]-nums[0]);
    }
        
    return res;
};