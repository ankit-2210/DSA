class Solution{
    public char processStr(String s, long k){
        int n=s.length();

        long len=0;
        for(char ch: s.toCharArray()){
            if(ch == '*'){
                len -= 1;
            }
            else if(ch == '#'){
                len *= 2;
            }
            else if(ch == '%'){
                continue;
            }
            else{
                len++;
            }
            if(len<0)
                len=0;
        }

        k++;
        if(k>len)
            return '.';

        for(int i=s.length()-1; i>=0; i--){
            if(s.charAt(i) == '*'){
                len++;
            }
            else if(s.charAt(i) == '#'){
                if(k>(len/2)){
                    k -= (len/2);
                }
                len/=2;
            }
            else if(s.charAt(i) == '%'){
                k=(len-k+1);
            }
            else{
                if(k == len)
                    return s.charAt(i);
                len--;
            }
        }

        return '.';

    }
}