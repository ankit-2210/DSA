class Solution{
    public int numberOfSpecialChars(String w){
        int n=w.length();

        int[] lower=new int[26];
        Arrays.fill(lower, -1);
        int[] upper=new int[26];
        Arrays.fill(upper, -1);

        for(int i=0; i<n; i++){
            if(Character.isLowerCase(w.charAt(i))){
                lower[w.charAt(i)-'a']=i;
            }
            else{
                if(upper[w.charAt(i)-'A'] == -1){
                    upper[w.charAt(i)-'A']=i;
                }
            }
        }

        int res=0;
        for(int i=0; i<26; i++){
            if(lower[i] != -1 && lower[i]<upper[i]){
                res+=1;
            }
        }

        return res;

    }
}