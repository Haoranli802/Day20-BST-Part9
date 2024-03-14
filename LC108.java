class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length);
    }
    private TreeNode helper(int[] nums, int start, int end){
        if(start >= end) return null;
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, start, mid);
        root.right = helper(nums, mid + 1, end);
        return root;
    }
}
O(N), O(N) 左闭右开

class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    private TreeNode helper(int[] nums, int start, int end){
        if(start > end) return null;
        int mid = (end + start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, start, mid-1);
        root.right = helper(nums, mid + 1, end);
        return root;
    }
}
O(N), O(N) 左闭右闭
