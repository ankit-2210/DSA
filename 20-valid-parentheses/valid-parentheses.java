class Solution{
    public boolean isValid(String s){
        int n=s.length();

        Stack<Character> st=new Stack<>();
        for(Character ch: s.toCharArray()){
            if(!st.isEmpty() && ch == ')'){
                if(st.peek() == '('){
                    st.pop();
                }
                else{
                    return false;
                }
            }
            else if(!st.isEmpty() && ch == '}'){
                if(st.peek() == '{'){
                    st.pop();
                }
                else{
                    return false;
                }
            }
            else if(!st.isEmpty() && ch == ']'){
                if(st.peek() == '['){
                    st.pop();
                }
                else{
                    return false;
                }
            }
            else{
                st.push(ch);
            }
        }

        if(!st.isEmpty())
            return false;

        return true;
    }
}