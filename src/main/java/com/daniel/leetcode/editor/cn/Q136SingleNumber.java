//给定一个非空整数数组，除了某个元素只出现一次以外，其余每个元素均出现两次。找出那个只出现了一次的元素。
//
// 说明： 
//
// 你的算法应该具有线性时间复杂度。 你可以不使用额外空间来实现吗？ 
//
// 示例 1: 
//
// 输入: [2,2,1]
//输出: 1
// 
//
// 示例 2: 
//
// 输入: [4,1,2,1,2]
//输出: 4 
// Related Topics 位运算 数组 👍 2394 👎 0


package com.daniel.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Q136SingleNumber {
	public static void main(String[] args) {
		Solution solution = new Q136SingleNumber().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		int single=0;
		public int singleNumber(int[] nums) {
			for (int num : nums) {
				single ^= num;
			}
			return single;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
