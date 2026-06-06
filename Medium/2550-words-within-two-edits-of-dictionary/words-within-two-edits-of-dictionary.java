class Solution{
    static final int ALPHABET_SIZE=26;
    class TrieNode{
        TrieNode[] children=new TrieNode[ALPHABET_SIZE];
        boolean isEnd;

        TrieNode(){
            isEnd=false;
            for(int i=0; i<ALPHABET_SIZE; i++){
                children[i]=null;
            }
        }
    }

    TrieNode root;
    public Solution(){
        root=new TrieNode();
    }

    public void insert(String w){
        TrieNode pCrawl=root;
        for(char ch: w.toCharArray()){
            int idx=ch-'a';
            if(pCrawl.children[idx] == null){
                pCrawl.children[idx]=new TrieNode();
            }
            pCrawl=pCrawl.children[idx];
        }
        pCrawl.isEnd=true;
    }

    boolean solve(int idx, String w, int ed, TrieNode node){
        if(ed>2)
            return false;
        if(idx == w.length()){
            if(node.isEnd)
                return true;
            return false;
        }

        for(int i=0; i<26; i++){
            if(node.children[i] != null){
                if(i == w.charAt(idx)-'a'){
                    if(solve(idx+1, w, ed, node.children[i]))
                        return true;
                }
                else{
                    if(solve(idx+1, w, ed+1, node.children[i]))
                        return true;
                }
            }
        }

        return false;
    }


    public List<String> twoEditWords(String[] q, String[] d){
        int n=q.length;
        int m=d.length;

        TrieNode pCrawl=root;
        for(String it: d){
            insert(it);
        }

        List<String> res=new ArrayList<>();
        for(String it: q){
            if(solve(0, it, 0, pCrawl)){
                res.add(it);
            }
        }

        return res;
    }
}