class Solution{
    public int numberOfSpecialChars(String w){
        int n=w.length();

        int[] lower=new int[26];
        int[] upper=new int[26];
        for(char ch: w.toCharArray()){
            if(Character.isLowerCase(ch)){
                lower[ch-'a'] +=1;
            }
            else{
                upper[ch-'A'] += 1;
            }
        }

        int res=0;
        for(int i=0; i<26; i++){
            if(lower[i]>0 && upper[i]>0){
                res+=1;
            }
        }

        return res;

    }
}