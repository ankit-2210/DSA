class Solution{
    public int numberOfSubstrings(String s){
        int n=s.length();

        HashMap<Character, Integer> mp=new HashMap<>();
        int res=0;
        int i=0, j=0;
        while(j<n){
            mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0) + 1);
            while(i<=j && mp.size() == 3){
                res += (n-j);
                char ch=s.charAt(i);
                mp.put(ch, mp.get(ch)-1);

                if(mp.get(ch) == 0){
                    mp.remove(ch);
                }

                i++;
            }
            j++;
        }

        return res;

    }
}