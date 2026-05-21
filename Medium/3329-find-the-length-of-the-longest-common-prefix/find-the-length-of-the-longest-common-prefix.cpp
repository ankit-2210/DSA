class Solution{
    static const int ALPHABET_SIZE=10;
    struct TrieNode{
        TrieNode *children[ALPHABET_SIZE];
        bool isEnd;
        int count;
    };

    TrieNode *root;
    TrieNode *getNode(){
        TrieNode *pNode=new TrieNode();
        for(int i=0; i<ALPHABET_SIZE; i++){
            pNode->children[i]=NULL;
        }
        pNode->isEnd;
        pNode->count=0;
        return pNode;
    }
public:
    Solution(){
        root=new TrieNode();
    }

    void insert(int num){
        TrieNode *pCrawl=root;
        string str=to_string(num);
        for(int i=0; i<str.size(); i++){
            int idx=str[i]-'0';
            if(!pCrawl->children[idx]){
                pCrawl->children[idx]=getNode();
            }
            pCrawl->children[idx]->count += 1;
            pCrawl=pCrawl->children[idx];
        }
        pCrawl->isEnd=true;
    }

    void search(int num, int &c){
        TrieNode *pCrawl=root;
        string str=to_string(num);
        for(int i=0; i<str.size(); i++){
            int idx=str[i]-'0';
            if(!pCrawl->children[idx]){
                return;
            }
            // res=max(res, pCrawl->children[idx]->count);
            pCrawl=pCrawl->children[idx];
            c++;
        }

    }

    int longestCommonPrefix(vector<int> &arr1, vector<int> &arr2){
        int n=arr1.size();
        int m=arr2.size();

        TrieNode *pCrawl=root;
        for(int i=0; i<n; i++){
            insert(arr1[i]);
        }

        int res=0;
        for(int i=0; i<m; i++){
            int c=0;
            search(arr2[i], c);
            res=max(res, c);
        }

        return res;

    }
};