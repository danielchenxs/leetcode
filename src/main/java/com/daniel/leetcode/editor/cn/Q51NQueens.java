//n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。 
//
// 
// 
// 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 4
//输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：[["Q"]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
// 
// 
// Related Topics 数组 回溯 👍 1116 👎 0


package com.daniel.leetcode.editor.cn;

import java.util.*;

public class Q51NQueens {
	public static void main(String[] args) {
		Solution solution = new Q51NQueens().new Solution();
		System.out.println(solution.solveNQueens(5));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		List<String> temp = new ArrayList<>();
		List<List<String>> ans = new ArrayList<>();
		Map<String, Object> x = new HashMap<>();
		Map<String, Object> y = new HashMap<>();
		Map<String, Object> sum = new HashMap<>();
		Map<String, Object> sub = new HashMap<>();
		String baseStr = "";

		public List<List<String>> solveNQueens(int n) {
			char[] chars = new char[n];
			Arrays.fill(chars, '.');
			baseStr = new String(chars);
			dfs(n, 0);
			return ans;
		}

		private void dfs(int n, int curLine) {
			if (temp.size() == n) {
				ans.add(new ArrayList<>(temp));
				return;
			}
			for (int i = 0; i < n; i++) {
				boolean valid = checkValid(i, curLine);
				if (valid) {
					StringBuilder sb = new StringBuilder(baseStr);
					sb.replace(i, i + 1, "Q");
					temp.add(sb.toString());
					dfs(n, curLine + 1);
					temp.remove(temp.size() - 1);
					sum.remove((i + curLine) + "");
					sub.remove((i - curLine) + "");
					x.remove(i + "");
					y.remove(curLine + "");
				}
			}
		}

		private boolean checkValid(int i, int curLine) {
			if (temp.isEmpty()) {
				x.clear();
				y.clear();
				sum.clear();
				sub.clear();
				sum.put((i + curLine)+"",(i + curLine)+"");
				sub.put((i - curLine)+"",(i - curLine)+"");
				x.put(i + "", i + "");
				y.put(curLine + "", curLine + "");
				return true;
			} else {
				boolean sumFlag = sum.get((i + curLine) + "") == null;
				boolean subFlag = sub.get((i - curLine) + "") == null;
				boolean xExisit = x.get(i + "") == null;
				if (sumFlag && subFlag && xExisit) {
					x.put(i + "", i + "");
					y.put(curLine + "", curLine + "");
					sum.put((i + curLine)+"",(i + curLine)+"");
					sub.put((i - curLine)+"",(i - curLine)+"");
					return true;
				}
			}
			return false;
		}

	}
//leetcode submit region end(Prohibit modification and deletion)

}
