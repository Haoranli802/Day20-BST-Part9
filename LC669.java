class Solution {
    //iteration
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null)
            return null;
        while(root != null && (root.val < low || root.val > high)){
            if(root.val < low)
                root = root.right;
            else
                root = root.left;
        }

        TreeNode curr = root;
        
        //deal with root's left sub-tree, and deal with the value smaller than low.
        while(curr != null){
            while(curr.left != null && curr.left.val < low){
                curr.left = curr.left.right;
            }
            curr = curr.left;
        }
        //go back to root;
        curr = root;

        //deal with root's righg sub-tree, and deal with the value bigger than high.
        while(curr != null){
            while(curr.right != null && curr.right.val > high){
                curr.right = curr.right.left;
            }
            curr = curr.right;
        }
        return root;
    }
}
// O(N), O(1) 迭代

class Solution {
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if(root == null) return null;
        if(root.val < low) return trimBST(root.right, low, high);
        else if(root.val > high) return trimBST(root.left, low, high);
        else{
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
            return root;
        }
    }
}
//O(N), O(N) 递归
