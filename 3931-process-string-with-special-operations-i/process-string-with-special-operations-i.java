class Solution{
    public String processStr(String s){
        int n=s.length();

        StringBuilder str=new StringBuilder();
        for(char ch: s.toCharArray()){
            if(ch == '*'){
                if(str.length()>0){
                    str.deleteCharAt(str.length()-1);
                }
            }
            else if(ch == '#'){
                str=new StringBuilder(str.toString().repeat(2));
            }
            else if(ch == '%'){
                if(str.length()>0){
                    str.reverse();
                }
            }
            else{
                str.append(ch);
            }
        }

        return str.toString();
        

    }
}