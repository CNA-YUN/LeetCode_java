class Solution543 {
    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxDiameter;
    }

    // 返回当前节点子树的最大深度
    private int dfs(TreeNode node) {
        if (node == null) return 0;
        int leftDepth = dfs(node.left);
        int rightDepth = dfs(node.right);
        // 穿过当前节点的路径长度 = 左深 + 右深
        maxDiameter = Math.max(maxDiameter, leftDepth + rightDepth);
        // 返回深度给上层
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
