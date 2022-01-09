//字典 wordList 中从单词 beginWord 和 endWord 的 转换序列 是一个按下述规格形成的序列：
//
// 
// 序列中第一个单词是 beginWord 。 
// 序列中最后一个单词是 endWord 。 
// 每次转换只能改变一个字母。 
// 转换过程中的中间单词必须是字典 wordList 中的单词。 
// 
//
// 给你两个单词 beginWord 和 endWord 和一个字典 wordList ，找到从 beginWord 到 endWord 的 最短转换序列 中
//的 单词数目 。如果不存在这样的转换序列，返回 0。 
// 
//
// 示例 1： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log","cog"]
//输出：5
//解释：一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog", 返回它的长度 5。
// 
//
// 示例 2： 
//
// 
//输入：beginWord = "hit", endWord = "cog", wordList = ["hot","dot","dog","lot",
//"log"]
//输出：0
//解释：endWord "cog" 不在字典中，所以无法进行转换。 
//
// 
//
// 提示： 
//
// 
// 1 <= beginWord.length <= 10 
// endWord.length == beginWord.length 
// 1 <= wordList.length <= 5000 
// wordList[i].length == beginWord.length 
// beginWord、endWord 和 wordList[i] 由小写英文字母组成 
// beginWord != endWord 
// wordList 中的所有字符串 互不相同 
// 
// Related Topics 广度优先搜索 哈希表 字符串 👍 910 👎 0


package com.daniel.leetcode.editor.cn;

import java.util.*;

public class Q127WordLadder {
	public static void main(String[] args) {
		Solution solution = new Q127WordLadder().new Solution();
	}

	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		Map<String, Integer> wordIdMap = new HashMap<>();
		List<List<Integer>> ans = new ArrayList<>();
		Queue<Integer> que = new LinkedList<>();
		int num = 0;

		public int ladderLength(String beginWord, String endWord, List<String> wordList) {
			for (String s : wordList) {
				addEdge(s);
			}
			addEdge(beginWord);
			if (!wordIdMap.containsKey(endWord)) {
				return 0;
			}
			int[] ids = new int[num];
			Arrays.fill(ids,Integer.MAX_VALUE);
			int beginId = wordIdMap.get(beginWord);
			int endId = wordIdMap.get(endWord);
			ids[beginId] = 0;
			que.offer(beginId);
			while (!que.isEmpty()) {
				int x = que.poll();
				if (x==endId) {
					return ids[endId]/2+1;
				}
				for (int it : ans.get(x)) {
					if (ids[it] == Integer.MAX_VALUE) {
						ids[it]=ids[x]+1;
						que.offer(it);
					}
				}
			}
			return 0;

		}

		private void addEdge(String s) {
			addWord(s);
			int id1 = wordIdMap.get(s);
			char[] chars = s.toCharArray();
			for (int i = 0; i < chars.length; ++i) {
				char temp = chars[i];
				chars[i] = '*';
				String str = new String(chars);
				addWord(str);
				int id2 = wordIdMap.get(str);
				ans.get(id1).add(id2);
				ans.get(id2).add(id1);
				chars[i]=temp;
			}
		}

		private void addWord(String s) {
			if (!wordIdMap.containsKey(s)) {
				wordIdMap.put(s, num++);
				ans.add(new ArrayList<>());
			}
		}
	}

//leetcode submit region end(Prohibit modification and deletion)

}
