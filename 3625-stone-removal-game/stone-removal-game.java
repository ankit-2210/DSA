class Solution{
    public boolean canAliceWin(int n){

        int t=10;
        boolean alice=true;

        while(n>=t){
            n -= t;
            t--;
            alice=!alice;
        }

        return !alice;

    }
}