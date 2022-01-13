//给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
//
// 说明：每次只能向下或者向右移动一步。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
//输出：7
//解释：因为路径 1→3→1→1→1 的总和最小。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[1,2,3],[4,5,6]]
//输出：12
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 200 
// 0 <= grid[i][j] <= 100 
// 
// Related Topics 数组 动态规划 矩阵 👍 1114 👎 0


package com.daniel.leetcode.editor.cn;

public class Q64MinimumPathSum {
	public static void main(String[] args) {
		Solution solution = new Q64MinimumPathSum().new Solution();
		int[][] ints = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
		System.out.println(solution.minPathSum(ints));
	}
	//leetcode submit region begin(Prohibit modification and deletion)

	//				Runtime:4 ms, faster than 5.15% of Java online submissions.
	//				Memory Usage:41.2 MB, less than 28.19% of Java online submissions.
	//  使用二维数组
//class Solution {
//    public int minPathSum(int[][] grid) {
//        int m = grid.length;
//        int n = grid[0].length;
//        int[][] dp = new int[m+1][n+1];
//
//        // f(m,n) = Min(f(m-1,n),f(m,n-1))
//        for (int i = 1; i < m+1; i++) {
//            for (int j = 1; j < n+1; j++) {
//                if (i == 1 & j>1) {
//                    dp[i][j] = dp[i][j - 1] + grid[i - 1][j - 1];
//                    continue;
//                }
//                if (j == 1 & i > 1) {
//                    dp[i][j] = dp[i-1][j] + grid[i - 1][j - 1];
//                    continue;
//                }
//                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1])+grid[i-1][j-1];
//            }
//        }
//        return dp[m][n];
//
//    }
//}

	//				Runtime:2 ms, faster than 96.49% of Java online submissions.
	//				Memory Usage:41.2 MB, less than 39.69% of Java online submissions.
	// 通过滚动数组，将二维压缩成一维。
	class Solution {
		public int minPathSum(int[][] grid) {
			int m = grid.length;
			int n = grid[0].length;
			int[] f = new int[n];
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (j == 0) {
						f[j] = f[j] + grid[i][j];
						continue;
					}
					if (i == 0) {
						f[j] = f[j - 1] + grid[i][j];
						continue;
					}
					f[j] = Math.min(f[j-1], f[j]) + grid[i][j];
				}

			}
			return f[n - 1];

		}
	}


//leetcode submit region end(Prohibit modification and deletion)

}
