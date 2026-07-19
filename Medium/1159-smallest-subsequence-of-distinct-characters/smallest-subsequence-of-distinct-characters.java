class Solution{
    public String smallestSubsequence(String s){
        int n=s.length();

        Stack<Character> st=new Stack<>();
        boolean[] visited=new boolean[26];
        HashMap<Character, Integer> mp=new HashMap<>();

        for(int i=0; i<n; i++){
            char ch=s.charAt(i);
            mp.put(ch, mp.getOrDefault(ch, 0)+1);
        }

        for(int i=0; i<n; i++){
            char ch=s.charAt(i);
            mp.put(ch, mp.get(ch)-1);

            if(visited[ch-'a'] == true)
                continue;

            while(!st.isEmpty() && st.peek()>ch && mp.get(st.peek())>0){
                visited[st.peek()-'a']=false;
                st.pop();
            }

            st.push(ch);
            visited[ch-'a']=true;
        }

        StringBuilder res=new StringBuilder();
        for(char ch: st){
            res.append(ch);
        }

        // res.reverse();

        return res.toString();

    }
}