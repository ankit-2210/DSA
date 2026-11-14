/**
 * @param {number[]} nums
 * @param {number} l
 * @param {number} r
 * @return {number}
 */
var minimumSumSubarray = function(nums, l, r) {
    const n=nums.length;

    let res=Infinity;
    for(let k=l; k<=r; k++){
        let curr=0;
        let i=0, j=0;
    
        while(j<n){
            curr += nums[j];
            while(j-i+1 == k){
                if(curr>0){
                    res=Math.min(res, curr);
                }
                curr -= nums[i];
                i++;
            }

            j++;
        }
    }

    if(res == Infinity)
        return -1;

    return res;

};