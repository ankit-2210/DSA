class Solution{
    public int scoreOfParentheses(String s){
        int n=s.length();

        int score=0;
        Stack<Integer> st=new Stack<>();
        for(int i=0; i<n; i++){
            Character ch=s.charAt(i);
            if(ch == '('){
                st.push(score);
                score=0;
            }
            else if(ch == ')'){
                score=st.peek()+Math.max(2*score, 1);
                st.pop();
            }
        }        

        return score;

    }
}