  //给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出：3
//解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
// 
//
// 示例 2： 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出：5
//解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], p = 1, q = 2
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [2, 10⁵] 内。 
// -10⁹ <= Node.val <= 10⁹ 
// 所有 Node.val 互不相同 。 
// p != q 
// p 和 q 均存在于给定的二叉树中。 
// 
// Related Topics 树 深度优先搜索 二叉树 👍 1404 👎 0

  
  package com.daniel.leetcode.editor.cn;

  import com.daniel.leetcode.TreeNode;

  import java.util.HashMap;
  import java.util.HashSet;
  import java.util.Map;
  import java.util.Set;

  public class Q236LowestCommonAncestorOfABinaryTree{
      public static void main(String[] args) {
           Solution solution = new Q236LowestCommonAncestorOfABinaryTree().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    Map<Integer,TreeNode> treeNodeMap = new HashMap<>();
    Set<TreeNode> visitedSet = new HashSet<>();
    int searchNodeNum=0;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        searchNode(root,p,q);
        return findNode(p, q);
    }

    public void searchNode(TreeNode root,TreeNode p, TreeNode q) {
        if (root==p||root==q) {
            searchNodeNum++;
            if (searchNodeNum == 2) {
                return;
            }
        }
        if (root.left != null) {
            treeNodeMap.put(root.left.val, root);
            searchNode(root.left,p,q);
        }
        if (root.right != null) {
            treeNodeMap.put(root.right.val, root);
            searchNode(root.right,p,q);
        }

    }

    public TreeNode findNode(TreeNode p, TreeNode q) {
        while (p != null) {
            visitedSet.add(p);
            p= treeNodeMap.get(p.val);
        }
        while (q != null) {
            if (visitedSet.contains(q)) {
                return q;
            }
            q = treeNodeMap.get(q.val);
        }
        return null;

    }

}
//leetcode submit region end(Prohibit modification and deletion)

  }
