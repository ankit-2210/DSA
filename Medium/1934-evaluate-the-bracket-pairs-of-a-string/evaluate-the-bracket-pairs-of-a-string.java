class Solution{
    public String evaluate(String s, List<List<String>> k){
        int n=s.length();

        HashMap<String, String> mp=new HashMap<>();
        for(List<String> x: k){
            mp.put(x.get(0), x.get(1));
        }

        StringBuilder sb=new StringBuilder();
        for(int i=0; i<n; i++){
            char ch=s.charAt(i);
            if(ch == '('){
                int j=i+1;
                while(s.charAt(j) != ')'){
                    j++;
                }

                String key = s.substring(i+1, j);
                sb.append(mp.getOrDefault(key, "?"));
                i=j;
            }
            else{
                sb.append(ch);
            }
        }

        return sb.toString();
    }
}