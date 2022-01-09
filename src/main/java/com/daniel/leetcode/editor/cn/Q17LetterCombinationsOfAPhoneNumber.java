//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 👍 1634 👎 0


package com.daniel.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q17LetterCombinationsOfAPhoneNumber {
	public static void main(String[] args) {
		Solution solution = new Q17LetterCombinationsOfAPhoneNumber().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		List<String> ans = new ArrayList<>();
		String temp = "";
		Map<Character, String> phoneMap = new HashMap<>();

		public List<String> letterCombinations(String digits) {
			if (digits.length() == 0) {
				return new ArrayList<>();
			}
			phoneMap = new HashMap<Character, String>() {{
				put('2', "abc");
				put('3', "def");
				put('4', "ghi");
				put('5', "jkl");
				put('6', "mno");
				put('7', "pqrs");
				put('8', "tuv");
				put('9', "wxyz");
			}};
			char[] chars = digits.toCharArray();
			dfs(chars, 0);
			return ans;
		}

		public void dfs(char[] chars, int cur) {
			if (cur > chars.length) {
				return;
			}
			if (temp.length() == chars.length) {
				ans.add(temp);
				return;
			}
			String str = phoneMap.get(chars[cur]);
			char[] strArray = str.toCharArray();
			for (char c : strArray) {
				temp += (String.valueOf(c));
				dfs(chars, cur + 1);
				temp = temp.substring(0, temp.length() - 1);
			}

		}

	}
//leetcode submit region end(Prohibit modification and deletion)

}
