//给定一个二叉树，返回其节点值自底向上的层序遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其自底向上的层序遍历为： 
//
// 
//[
//  [15,7],
//  [9,20],
//  [3]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 👍 517 👎 0


package com.daniel.leetcode.editor.cn;

import com.daniel.leetcode.TreeNode;

import java.util.*;

public class Q107BinaryTreeLevelOrderTraversalIi {
	public static void main(String[] args) {
		Solution solution = new Q107BinaryTreeLevelOrderTraversalIi().new Solution();
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
		Map<Integer, List<Integer>> ansMap = new HashMap<>();

		public List<List<Integer>> levelOrderBottom(TreeNode root) {
			dfs(root, 0);
            List<List<Integer>> list = new ArrayList<>(ansMap.values());
            Collections.reverse(list);
            return list;
		}

		private void dfs(TreeNode root, int i) {
			if (root == null) {
				return;
			}
			List<Integer> list = ansMap.get(i);
			list = list == null ? new ArrayList<>() : list;
			list.add(root.val);
			ansMap.put(i, list);
			dfs(root.left, i + 1);
			dfs(root.right, i + 1);
		}


	}
//leetcode submit region end(Prohibit modification and deletion)

}
