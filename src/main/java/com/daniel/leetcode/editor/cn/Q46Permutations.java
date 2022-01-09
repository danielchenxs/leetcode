//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 👍 1667 👎 0


package com.daniel.leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

public class Q46Permutations {
	public static void main(String[] args) {
		Solution solution = new Q46Permutations().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> temp;

		public List<List<Integer>> permute(int[] nums) {
			temp = Arrays.stream(nums).boxed().collect(Collectors.toList());
			backTrack(temp.size(), 0);
			return ans;
		}

		private void backTrack(int size,  int first) {
			if (first == size) {
				ans.add(new ArrayList<>(temp));
			}
			for (int j = first; j < size; j++) {
				Collections.swap(temp,j,first);
				backTrack(size, first+1);
				Collections.swap(temp,j,first);
			}
		}


	}
//leetcode submit region end(Prohibit modification and deletion)

}
