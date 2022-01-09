//给定一个三角形 triangle ，找出自顶向下的最小路径和。
//
// 每一步只能移动到下一行中相邻的结点上。相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。也就是说，如果
//正位于当前行的下标 i ，那么下一步可以移动到下一行的下标 i 或 i + 1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
//输出：11
//解释：如下面简图所示：
//   2
//  3 4
// 6 5 7
//4 1 8 3
//自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
// 
//
// 示例 2： 
//
// 
//输入：triangle = [[-10]]
//输出：-10
// 
//
// 
//
// 提示： 
//
// 
// 1 <= triangle.length <= 200 
// triangle[0].length == 1 
// triangle[i].length == triangle[i - 1].length + 1 
// -10⁴ <= triangle[i][j] <= 10⁴ 
// 
//
// 
//
// 进阶： 
//
// 
// 你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题吗？ 
// 
// Related Topics 数组 动态规划 👍 931 👎 0


package com.daniel.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q120Triangle {
	public static void main(String[] args) {
		Solution solution = new Q120Triangle().new Solution();

		List<List<Integer>> list = new ArrayList<>();
		list.add(Arrays.asList(-1));
		list.add(Arrays.asList(-2, -3));
		list.add(Arrays.asList(1, -1, -3));

		int i = solution.minimumTotal(list);
		System.out.println(i);
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	//DP, 一维数组自底向上
	class Solution2 {
		public int minimumTotal(List<List<Integer>> triangle) {
			int size = triangle.size();
			int[] A = new int[triangle.size() + 1];
			for (int i = size - 1; i >= 0; i--) {
				for (int j = 0; j <= i; j++) {
					A[j] = Math.min(A[j], A[j + 1]) + triangle.get(i).get(j);
				}
			}
			return A[0];
		}
	}

	//DP, 二维数组自底向上
	class Solution3 {
		public int minimumTotal(List<List<Integer>> triangle) {
			int size = triangle.size();
			//+1多出一行0，避免下标越界
			int[][] dp = new int[size + 1][size + 1];
			for (int i = size - 1; i >= 0; i--) {
				for (int j = 0; j <= i; j++) {
					dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
				}
			}
			return dp[0][0];
		}
	}
	//递归，缓存中间值
	class Solution {
		Integer[][] cache ;
		public int minimumTotal(List<List<Integer>> triangle) {
			 cache=new Integer[triangle.size()][triangle.size()];

			return dfs(0, 0, triangle);
		}

		private int dfs(int lastIndex, int level, List<List<Integer>> triangle) {
			if (level == triangle.size()) {
				return 0;
			}
			if (cache[level][lastIndex] != null) {
				return cache[level][lastIndex];
			}
			return cache[level][lastIndex]=Math.min(dfs(lastIndex,level+1,triangle),dfs(lastIndex+1,level+1,triangle))+triangle.get(level).get(lastIndex);

		}
	}


//leetcode submit region end(Prohibit modification and deletion)

}
