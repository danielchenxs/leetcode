//给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
//
// 
//
// 示例： 
//二叉树：[3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回其层序遍历结果： 
//
// 
//[
//  [3],
//  [9,20],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 👍 1115 👎 0


package com.daniel.leetcode.editor.cn;

import com.daniel.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q102BinaryTreeLevelOrderTraversal {
	public static void main(String[] args) {
		Solution solution = new Q102BinaryTreeLevelOrderTraversal().new Solution();
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
		Deque<TreeNode> queue = new LinkedList<>();
		List<List<Integer>> ans = new ArrayList<>();

		public List<List<Integer>> levelOrder(TreeNode root) {
			queue.add(root);
			bfs();
			return ans;
		}

		private void bfs() {
			while (!queue.isEmpty()) {
				List<Integer> list = new ArrayList<>();
				Deque<TreeNode> nodeList = new LinkedList<>();
				for (TreeNode treeNode : queue) {
					if (treeNode == null) {
						return;
					}
					list.add(treeNode.val);
					if (treeNode.left != null) {
						nodeList.add(treeNode.left);
					}
					if (treeNode.right!=null) {
						nodeList.add(treeNode.right);
					}
				}
				ans.add(list);
				queue=nodeList;
			}
		}

	}
//leetcode submit region end(Prohibit modification and deletion)

}
