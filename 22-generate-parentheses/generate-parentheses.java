class Solution{
    void solve(StringBuilder str, int open, int close, List<String> temp){
        if(open == 0 && close == 0){
            temp.add(str.toString());
            return;
        }

        if(open>0){
            str.append('(');
            solve(str, open-1, close, temp);
            str.deleteCharAt(str.length()-1);
        }
        if(open<close){
            str.append(')');
            solve(str, open, close-1, temp);
            str.deleteCharAt(str.length()-1);
        }

    }

    public List<String> generateParenthesis(int n){
        
        List<String> res=new ArrayList<>();
        StringBuilder str=new StringBuilder();
        solve(str, n, n, res);

        return res;

    }
}