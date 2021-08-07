problem : https://leetcode.com/explore/featured/card/august-leetcoding-challenge-2021/613/week-1-august-1st-august-7th/3838/
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
class Solution {
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        List<List<Integer>> ans  =  new ArrayList<>();
        if(root==null) return ans;
        List<Integer> temp =  new ArrayList<>(){{
            add(root.val);
        }};
        
        helper(root,targetSum - root.val , ans , temp);
        return ans;
        
     
        
    }
    private void helper(TreeNode root , int target , List<List<Integer>> ans , List<Integer> temp){
        
        
        
        
        if(target==0 && (root.left==null && root.right==null)){
            
            ans.add(new ArrayList(temp));
            return ;
        }
        
        if(root==null) return ;
        
        
        if(root.left!=null){
            temp.add(root.left.val);
            helper(root.left,target-root.left.val,ans,temp);
            temp.remove(temp.size()-1);
            }
        if(root.right!=null){ 
            temp.add(root.right.val);
            helper(root.right,target-root.right.val,ans,temp);
            temp.remove(temp.size()-1);
            }
        
        
        
    }
}

