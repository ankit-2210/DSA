class Solution{
public:
    int furthestDistanceFromOrigin(string m){
        int n=m.size();

        int left=0, right=0, count=0;
        for(int i=0; i<n; i++){
            if(m[i] == 'L'){
                left++;
            }
            else if(m[i] == 'R'){
                right++;
            }
            else{
                count++;
            }
        }

        if(left>=right)
            return left+count-right;

        return right+count-left;
    }
};