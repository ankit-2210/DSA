class Solution{
    public boolean isValid(String s){
        int n=s.length();

        Stack<Character> st=new Stack<>();
        for(Character ch: s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                st.push(ch);
            }
            else{
                if(st.isEmpty())
                    return false;
                
                if((ch == ')' && st.peek() != '(') || (ch == '}' && st.peek() != '{') || (ch == ']' && st.peek() != '['))
                    return false;

                st.pop();
            }
        }

        if(!st.isEmpty())
            return false;

        return true;
    }
}