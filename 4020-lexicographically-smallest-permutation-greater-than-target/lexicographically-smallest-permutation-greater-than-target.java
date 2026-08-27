class Solution {
    String solve(int[] freq){
        StringBuilder str = new StringBuilder();
        for (int i=0; i<26; i++){
            char c =(char)('a'+i);
            for(int j=0; j<freq[i]; j++){
                str.append(c);
            }
        }

        return str.toString();
    }

    public String lexGreaterPermutation(String s, String t){
        int n=s.length();
        int m=t.length();

        int[] freq=new int[26];
        for(char ch: s.toCharArray()){
            freq[ch-'a']++;
        }

        String res="";
        StringBuilder prefix=new StringBuilder();
        for(int i=0; i<m; i++){
            char ch = t.charAt(i);

            for(char c=(char)(ch+1); c<='z'; c++){
                if(freq[c-'a']>0){
                    freq[c-'a']--;

                    String suffix=solve(freq);
                    String str=prefix.toString()+c+suffix;
                    if (res.equals("") || str.compareTo(res)<0){
                        res=str;
                    }

                    freq[c-'a']++;
                    break;
                }
            }

            if(freq[ch-'a'] == 0)
                return res;

            freq[ch-'a']--;
            prefix.append(ch);
        }

        return res;
    }
}