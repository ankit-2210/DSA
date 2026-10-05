class Solution{
    public boolean checkValidString(String s){
        int n=s.length();

        int low=0, high=0;
        for(Character ch: s.toCharArray()){
            if(ch == '('){
                low++;
                high++;
            }
            else if(ch == ')'){
                low--;
                high--;
            }
            else{
                low--;
                high++;
            }
            if(low<0){
                low=0;
            }
            if(high<0)
                return false;
        }

        if(low == 0)
            return true;

        return false;

    }
}