class Solution{
    public List<String> maxNumOfSubstrings(String s){
        int n=s.length();

        int[] start=new int[26];
        int[] end=new int[26];

        Arrays.fill(start, -1);
        Arrays.fill(end, -1);

        for(int i=0; i<n; i++){
            int idx=s.charAt(i)-'a';

            if(start[idx] == -1){
                start[idx]=i;
            }
            end[idx]=i;
        }

        boolean[] isValid=new boolean[26];

        for(int c=0; c<26; c++){
            if(start[c] == -1)
                continue;

            isValid[c]=true;
            for(int i=start[c]; i<=end[c]; i++){
                int idx=s.charAt(i)-'a';
                if(start[idx]<start[c]){
                    isValid[c]=false;
                    break;
                }

                end[c]=Math.max(end[c], end[idx]);
            }
        }

        List<String> res=new ArrayList<>();
        int last=n;
        for(int i=n-1; i>=0; i--){
            int idx=s.charAt(i)-'a';

            if(isValid[idx] && i == start[idx] && end[idx]<last) {
                res.add(s.substring(i, end[idx]+1));
                last=i;
            }
        }

        return res;

    }
}