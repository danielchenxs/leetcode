//给你一个字符串 s，找到 s 中最长的回文子串。
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 5154 👎 0


package com.daniel.leetcode.editor.cn;

public class Q5LongestPalindromicSubstring {
	public static void main(String[] args) {
		Solution solution = new Q5LongestPalindromicSubstring().new Solution();
		solution.longestPalindrome("aaaa");
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public String longestPalindrome(String s) {
			final int length = s.length();
			if (length < 2) {
				return s;
			}
			int maxLen = 1;
			int begin = 0;
			final char[] chars = s.toCharArray();
			boolean[][] dp = new boolean[length][length];
			for (int i = 0; i < length; i++) {
				dp[i][i] = true;
			}
			for (int j = 1; j < s.length(); j++) {
				for (int i = 0; i < j; i++) {
					if (chars[i] != chars[j]) {
						dp[i][j] = false;
					} else {
						if (j - i < 3) {
							dp[i][j] = true;
						} else {
							dp[i][j] = dp[i + 1][j - 1];
						}
					}
					if (dp[i][j] && j - i + 1 > maxLen) {
						maxLen = j - i + 1;
						begin = i;
					}


				}

			}

			return s.substring(begin, begin + maxLen);
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
