class Solution{
    public int maxNumberOfBalloons(String t){
        int n=t.length();

        HashMap<Character, Integer> mp=new HashMap<>();
        for(char ch: t.toCharArray()){
            if(ch == 'b' || ch == 'a' || ch == 'l' || ch == 'o' || ch == 'n'){
                mp.put(ch, mp.getOrDefault(ch, 0)+1);
            }
        }

        if(mp.size()<5)
            return 0;

        int res=Integer.MAX_VALUE;
        for(char ch: t.toCharArray()){
            if(ch == 'b' || ch == 'a' || ch == 'n'){
                res=Math.min(res, mp.get(ch));
            }
            else if(ch == 'l' || ch == 'o'){   
                res=Math.min(res, mp.get(ch)/2);
            }
        }

        return res;

    }
}