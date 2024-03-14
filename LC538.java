class Solution {
    public TreeNode convertBST(TreeNode root) {
        int sum = 0;
        TreeNode node = root;

        while (node != null) {
            if (node.right == null) {
                sum += node.val;
                node.val = sum;
                node = node.left;
            } else {
                TreeNode succ = getSuccessor(node);
                if (succ.left == null) {
                    succ.left = node;
                    node = node.right;
                } else {
                    succ.left = null;
                    sum += node.val;
                    node.val = sum;
                    node = node.left;
                }
            }
        }

        return root;
    }

    public TreeNode getSuccessor(TreeNode node) {
        TreeNode succ = node.right;
        while (succ.left != null && succ.left != node) {
            succ = succ.left;
        }
        return succ;
    }
}
//O(N), O(1), Morris 中序遍历

class Solution {
    TreeNode pre = null;
    public TreeNode convertBST(TreeNode root) {
        convertHelper(root);
        return root;
    }
    public void convertHelper(TreeNode root){
        if(root == null) return;
        convertHelper(root.right);
        if(pre != null){
            root.val += pre.val;
        }
        pre = root;
        convertHelper(root.left);
    }
}
//O(N), O(N) 递归
