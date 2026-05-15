class Solution{
    static const int ALPHABET_SIZE=26;
    struct TrieNode{
        struct TrieNode *children[ALPHABET_SIZE];
        bool isEnd;
    };

    struct TrieNode *root;
    struct TrieNode *getNode(){
        struct TrieNode *pNode=new TrieNode();
        pNode->isEnd=false;
        for(int i=0; i<ALPHABET_SIZE; i++){
            pNode->children[i]=NULL;
        }
        return pNode;
    }

public:
    Solution(){
        root=getNode();
    }

    void insert(string &w){
        struct TrieNode *pCrawl=root;
        for(auto ch: w){
            int idx=ch-'a';
            if(!pCrawl->children[idx]){
                pCrawl->children[idx]=getNode();
            }
            pCrawl=pCrawl->children[idx];
        }
        pCrawl->isEnd=true;
    }

    bool solve(int idx, string &w, int ed, TrieNode *&node){
        if(ed>2)
            return false;
        if(idx == w.size()){
            if(node->isEnd)
                return true;
            return false;
        }

        for(int i=0; i<26; i++){
            if(node->children[i]){
                if(i == w[idx]-'a'){
                    if(solve(idx+1, w, ed, node->children[i]))
                        return true;
                }
                else{
                    if(solve(idx+1, w, ed+1, node->children[i]))
                        return true;
                }
            }
        }

        return false;
    }

    vector<string> twoEditWords(vector<string> &q, vector<string> &d){
        int n=q.size();
        int m=d.size();

        struct TrieNode *pCrawl=root;
        for(auto it: d){
            insert(it);
        }

        vector<string> res;
        for(auto it: q){
            if(solve(0, it, 0, pCrawl)){
                res.push_back(it);
            }
        }

        return res;
    }
};