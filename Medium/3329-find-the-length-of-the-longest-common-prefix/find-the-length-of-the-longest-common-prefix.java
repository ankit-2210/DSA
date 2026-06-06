class Solution{
    static final int ALPHABET_SIZE = 10;
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        int count;
        TrieNode(){
            children=new TrieNode[ALPHABET_SIZE];
            isEnd=false;
            count=0;
        }
    }

    TrieNode root;
    public Solution(){
        root=new TrieNode();
    }

    void insert(int num){
        TrieNode pCrawl=root;
        String str=Integer.toString(num);
        for(int i=0; i<str.length(); i++){
            int idx=str.charAt(i)-'0';
            if(pCrawl.children[idx] == null){
                pCrawl.children[idx]=new TrieNode();
            }
            pCrawl.children[idx].count += 1;
            pCrawl=pCrawl.children[idx];
        }
        pCrawl.isEnd=true;
    }

    int search(int num){
        TrieNode pCrawl=root;
        String str=Integer.toString(num);
        int c=0;
        for(int i=0; i<str.length(); i++){
            int idx=str.charAt(i)-'0';
            if(pCrawl.children[idx] == null){
                return c;
            }
            pCrawl=pCrawl.children[idx];
            c++;
        }
        return c;
    }
    

    public int longestCommonPrefix(int[] arr1, int[] arr2){
        int n=arr1.length;
        int m=arr2.length;

        TrieNode pCrawl=root;
        for(int i=0; i<n; i++){
            insert(arr1[i]);
        }

        int res=0;
        for(int i=0; i<m; i++){
            res=Math.max(res, search(arr2[i]));
        }

        return res;

    }
}








