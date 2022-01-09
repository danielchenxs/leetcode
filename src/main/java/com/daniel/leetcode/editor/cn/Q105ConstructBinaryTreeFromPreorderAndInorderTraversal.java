//给定一棵树的前序遍历 preorder 与中序遍历 inorder。请构造二叉树并返回其根节点。
//
// 
//
// 示例 1: 
//
// 
//Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//Output: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//Input: preorder = [-1], inorder = [-1]
//Output: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均无重复元素 
// inorder 均出现在 preorder 
// preorder 保证为二叉树的前序遍历序列 
// inorder 保证为二叉树的中序遍历序列 
// 
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1320 👎 0


package com.daniel.leetcode.editor.cn;

import com.daniel.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Q105ConstructBinaryTreeFromPreorderAndInorderTraversal {
	public static void main(String[] args) {
		Solution solution = new Q105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
	}
	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 * int val;
	 * TreeNode left;
	 * TreeNode right;
	 * TreeNode() {}
	 * TreeNode(int val) { this.val = val; }
	 * TreeNode(int val, TreeNode left, TreeNode right) {
	 * this.val = val;
	 * this.left = left;
	 * this.right = right;
	 * }
	 * }
	 */
	class Solution {
		Map<Integer, Integer> map = new HashMap<>();

		public TreeNode buildTree(int[] preorder, int[] inorder) {
			for (int i = 0; i < preorder.length; i++) {
				map.put(inorder[i], i);
			}
			return buildMyTree(preorder, inorder, 0, preorder.length - 1, 0, preorder.length - 1);
		}

		public TreeNode buildMyTree(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd) {
			if (preStart > preEnd) {
				return null;
			}
			int pre = preorder[preStart];
			Integer inRoot = map.get(pre);
			int leftCount = inRoot - inStart;
			TreeNode root = new TreeNode(pre);
			root.left = buildMyTree(preorder, inorder, preStart+1, preStart + leftCount, inStart, inRoot - 1);
			root.right = buildMyTree(preorder, inorder, preStart+leftCount+1,preEnd, inRoot+1, inEnd);
			return root;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
