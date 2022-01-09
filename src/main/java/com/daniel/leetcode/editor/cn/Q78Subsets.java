//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯 👍 1405 👎 0


package com.daniel.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Q78Subsets {
	public static void main(String[] args) {
		Solution solution = new Q78Subsets().new Solution();
		int[] num = {5, 2, 9};
		List<List<Integer>> subsets = solution.subsets(num);
		System.out.println(subsets);
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		List<Integer> t = new ArrayList<Integer>();
		List<List<Integer>> ans = new ArrayList<List<Integer>>();

		public List<List<Integer>> subsets(int[] nums) {
			int n = nums.length;
			for (int mask = 0; mask < (1 << n); ++mask) {
				t.clear();
				for (int i = 0; i < n; ++i) {
					if ((mask & (1 << i)) != 0) {
						t.add(nums[i]);
					}
				}
				ans.add(new ArrayList<Integer>(t));
			}
			return ans;
		}


	}
//leetcode submit region end(Prohibit modification and deletion)

}
