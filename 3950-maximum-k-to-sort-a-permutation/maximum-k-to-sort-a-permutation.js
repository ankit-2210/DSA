/**
 * @param {number[]} nums
 * @return {number}
 */
var sortPermutation = function(nums) {
    let n=nums.length;

    let bit=-1;
    for(let i=0; i<n; i++){
        if(nums[i] != i){
            if(bit == -1){
                bit=nums[i];
            }
            else{
                bit&=nums[i];
            }
        }
    }
        
    if(bit == -1)
        return 0;
        
    return bit;
};