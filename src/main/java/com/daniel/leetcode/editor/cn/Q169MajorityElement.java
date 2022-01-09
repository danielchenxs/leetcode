//给定一个大小为 n 的数组，找到其中的多数元素。多数元素是指在数组中出现次数 大于 ⌊ n/2 ⌋ 的元素。
//
// 你可以假设数组是非空的，并且给定的数组总是存在多数元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：[3,2,3]
//输出：3 
//
// 示例 2： 
//
// 
//输入：[2,2,1,1,1,2,2]
//输出：2
// 
//
// 
//
// 进阶： 
//
// 
// 尝试设计时间复杂度为 O(n)、空间复杂度为 O(1) 的算法解决此问题。 
// 
// Related Topics 数组 哈希表 分治 计数 排序 👍 1224 👎 0


package com.daniel.leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Q169MajorityElement {
	public static void main(String[] args) {
		Solution solution = new Q169MajorityElement().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int majorityElement(int[] nums) {
			List<Integer> list = Arrays.stream(nums).sorted().boxed().collect(Collectors.toList());
			return list.get(nums.length / 2);

		}
	}
//leetcode submit region end(Prohibit modification and deletion)

}
