class Solution{
    public int maximumLengthSubstring(String s){
        int n=s.length();

        HashMap<Character, Integer> mp=new HashMap<>();
        int res=0;
        int i=0, j=0;
        while(j<n){
            mp.put(s.charAt(j), mp.getOrDefault(s.charAt(j), 0)+1);

            while(mp.get(s.charAt(j))>2 && i<=j){
                mp.put(s.charAt(i), mp.getOrDefault(s.charAt(i), 0)-1);
                i++;
            }

            res=Math.max(res, j-i+1);
            j++;
        }

        return res;
    }
}