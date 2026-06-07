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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, TreeNode> map = new HashMap<>();
        Set<Integer> children = new HashSet<>();
        for (int[] d : descriptions) {
            int parent = d[0], child = d[1], isLeft = d[2];

            map.putIfAbsent(parent, new TreeNode(parent));
            map.putIfAbsent(child, new TreeNode(child));

            TreeNode pNode = map.get(parent);
            TreeNode cNode = map.get(child);

            if (isLeft == 1) pNode.left = cNode;
            else pNode.right = cNode;

            children.add(child);
        }
        for (int val : map.keySet()) {
            if (!children.contains(val)) {
                return map.get(val);
            }
        }
        return null;
    }
}