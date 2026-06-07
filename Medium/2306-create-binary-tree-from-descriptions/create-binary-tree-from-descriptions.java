/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution{
    public TreeNode createBinaryTree(int[][] d){
        HashMap<Integer, TreeNode> mp=new HashMap<>();
        Set<Integer> st=new HashSet<>();
        for(int[]it: d){
            int p=it[0];
            int c=it[1];
            int l=it[2];

            mp.putIfAbsent(p, new TreeNode(p));
            mp.putIfAbsent(c, new TreeNode(c));

            if(l == 1){
                mp.get(p).left=mp.get(c);
            }   
            else{
                mp.get(p).right=mp.get(c);
            }
            st.add(c);
        }

        for(int[] it: d){
            if(!st.contains(it[0]))
                return mp.get(it[0]);
        }

        return null;
    }
}


















