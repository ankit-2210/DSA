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
import java.util.concurrent.atomic.AtomicInteger;

class Solution{
    int solve(TreeNode root, AtomicInteger count, AtomicInteger res){
        if(root == null)
            return 0;

        AtomicInteger lcount = new AtomicInteger(0); 
        AtomicInteger rcount = new AtomicInteger(0);
        int lsum=solve(root.left, lcount, res);
        int rsum=solve(root.right, rcount, res);

        int sum=root.val+lsum+rsum;
        count.set(1+lcount.get()+rcount.get());

        if(root.val == sum/count.get())
            res.incrementAndGet();

        return sum;
    }

    public int averageOfSubtree(TreeNode root){
        AtomicInteger res=new AtomicInteger(0);
        AtomicInteger count=new AtomicInteger(0);

        solve(root, count, res);
        return res.get();

    }
}




















