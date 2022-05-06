//给你 root1 和 root2 这两棵二叉搜索树。请你返回一个列表，其中包含 两棵树 中的所有整数并按 升序 排序。.
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root1 = [2,1,4], root2 = [1,0,3]
//输出：[0,1,1,2,3,4]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root1 = [1,null,8], root2 = [8,1]
//输出：[1,1,8,8]
// 
//
// 
//
// 提示： 
//
// 
// 每棵树的节点数在 [0, 5000] 范围内 
// -10⁵ <= Node.val <= 10⁵ 
// 
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 排序 👍 116 👎 0


package com.daniel.leetcode.editor.cn;

import com.daniel.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Q1305AllElementsInTwoBinarySearchTrees {
	public static void main(String[] args) {
		Solution solution = new Q1305AllElementsInTwoBinarySearchTrees().new Solution();
		solution.getAllElements(new TreeNode(2, new TreeNode(1), new TreeNode(4)), new TreeNode(1, new TreeNode(0), new TreeNode(3)));
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
		private void recursion(TreeNode root, List<Integer> list) {
			if (root == null) {
				return;
			}
			recursion(root.left, list);
			list.add(root.val);
			recursion(root.right, list);

		}

		public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
			List<Integer> l1 = new ArrayList<>();
			List<Integer> l2 = new ArrayList<>();
			List<Integer> list = new ArrayList<>();
			recursion(root1, l1);
			recursion(root2, l2);

			if (l1.size() == 0) {
				return l2;
			}

			if (l2.size() == 0) {
				return l1;
			}

			int i1 = 0;
			int i2 = 0;

			while (true) {
				if (i1 > l1.size()-1) {
					break;
				}
				if (i2 > l2.size()-1) {
					break;
				}
				final Integer n1 = l1.get(i1);
				final Integer n2 = l2.get(i2);
				if (n1 >= n2) {
					list.add(n2);
					i2++;
				} else {
					list.add(n1);
					i1++;
				}

			}
			if (i1 == l1.size()) {
				list.addAll(l2.subList(i2, l2.size()));
			}
			if (i2 == l2.size()) {
				list.addAll(l1.subList(i1, l1.size()));
			}
			return list;
		}

	}
//leetcode submit region end(Prohibit modification and deletion)

}