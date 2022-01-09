//给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
//
// 你可以按 任何顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4, k = 2
//输出：
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
//
// 示例 2： 
//
// 
//输入：n = 1, k = 1
//输出：[[1]] 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 20 
// 1 <= k <= n 
// 
// Related Topics 数组 回溯 👍 785 👎 0


package com.daniel.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Q77Combinations {
	public static void main(String[] args) {
		Solution solution = new Q77Combinations().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		Deque<Integer> temp = new LinkedList<>();
		List<List<Integer>> ans = new ArrayList<>();

		public List<List<Integer>> combine(int n, int k) {
            dfs(1, n, k);
            return ans;
		}

		public void dfs(int cur, int n, int k) {
            if (temp.size() + (n - cur + 1) < k) {
                return;
            }
            if (temp.size() == k) {
                ans.add(new ArrayList<>(temp));
                return;
            }
            temp.push(cur);
            dfs(cur + 1, n, k);
            temp.pop();
            dfs(cur + 1, n, k);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
