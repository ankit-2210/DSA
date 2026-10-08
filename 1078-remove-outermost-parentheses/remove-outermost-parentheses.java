class Solution{
    public String removeOuterParentheses(String s){
        int n=s.length();

        int count=0;
        StringBuilder str = new StringBuilder();
        for(Character ch: s.toCharArray()){
            if(ch == '('){
                if(count>0){
                    str.append(ch);
                }
                count++;
            }
            else if(ch == ')'){
                count--;
                if(count>0){
                    str.append(ch);
                }
            }

        }

        return str.toString();

    }
}