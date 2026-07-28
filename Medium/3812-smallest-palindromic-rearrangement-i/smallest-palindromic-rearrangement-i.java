class Solution{
    public String smallestPalindrome(String s){
        int n=s.length();

        int[] freq=new int[26];
        for(char ch: s.toCharArray()){
            freq[ch-'a']++;
        }

        char[] temp=new char[n];
        int left=0, right=n-1;
        for(int i=0; i<26 && left<=right; i++){
            while(freq[i]>=2){
                temp[left++]=(char)(i+'a');
                temp[right--]=(char)(i+'a');
                freq[i]-=2;
            }
            if(freq[i] == 1){
                temp[n/2]=(char)(i+'a');
                freq[i]=0;
            }
        }

        return new String(temp);


    }
}