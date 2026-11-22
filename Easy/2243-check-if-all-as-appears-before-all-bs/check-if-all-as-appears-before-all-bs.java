class Solution{
    public boolean checkString(String s){
        int n=s.length();

        boolean flag=false;
        for(int i=0; i<n; i++){
            char ch=s.charAt(i);
            if(ch == 'a' && flag == true){
                return false;
            }
            else if(ch == 'b'){
                flag=true;
            }
        }

        return true;

    }
}