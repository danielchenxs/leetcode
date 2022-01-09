//实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，x⁴
//
// Related Topics 递归 数学 👍 800 👎 0


package com.daniel.leetcode.editor.cn;

public class Q50PowxN {
	public static void main(String[] args) {
		Solution solution = new Q50PowxN().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public double myPow(double x, int n) {
			if (n < 0) {
				x=1/x;
				n = -n;
			}
			return doPow(x, n);
		}

		public double doPow(double x, int n) {
			if (n == 0) {
				return 1.0;
			}
			double half = doPow(x, n / 2);
			return n%2==0?half*half:half*half*x;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
