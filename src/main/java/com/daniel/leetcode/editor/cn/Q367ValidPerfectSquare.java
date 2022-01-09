//给定一个 正整数 num ，编写一个函数，如果 num 是一个完全平方数，则返回 true ，否则返回 false 。
//
// 进阶：不要 使用任何内置的库函数，如 sqrt 。 
//
// 
//
// 示例 1： 
//
// 
//输入：num = 16
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：num = 14
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= num <= 2^31 - 1 
// 
// Related Topics 数学 二分查找 👍 327 👎 0


package com.daniel.leetcode.editor.cn;

public class Q367ValidPerfectSquare {
	public static void main(String[] args) {
		Solution solution = new Q367ValidPerfectSquare().new Solution();
        System.out.printf("result=", solution.isPerfectSquare(16));
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public boolean isPerfectSquare(int num) {
			double xi = num;
			double c = num;
			while (true) {
				if (xi * xi == c) {
					break;
				} else {
					double x0 = (xi + c / xi) / 2;
					if (Math.abs(x0 - xi) < 1e-7) {
						break;
					}
					xi = x0;
				}
			}
			xi=(int)xi;
			return xi*xi==c;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
