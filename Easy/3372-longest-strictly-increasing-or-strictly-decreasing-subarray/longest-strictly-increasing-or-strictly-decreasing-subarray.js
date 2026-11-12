/**
 * @param {number[]} nums
 * @return {number}
 */
var longestMonotonicSubarray = function(nums) {
    const n=nums.length;

    let mx=1;
    const inc=new Array(n).fill(1);
    for(let i=1; i<n; i++){
        if(nums[i-1]<nums[i]){
            inc[i]=1+inc[i-1];
        }
        mx=Math.max(mx, inc[i]);
    }

    const dec=new Array(n).fill(1);
    for(let i=n-2; i>=0; i--){
        if(nums[i+1]<nums[i]){
            dec[i]=1+dec[i+1];
        }
        mx=Math.max(mx, dec[i]);
    }

    return mx;

};