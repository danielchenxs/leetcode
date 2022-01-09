  //假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 记忆化搜索 数学 动态规划 👍 2042 👎 0

  
  package com.daniel.leetcode.editor.cn;
  public class Q70ClimbingStairs{
      public static void main(String[] args) {
           Solution solution = new Q70ClimbingStairs().new Solution();
      }
      //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int[] a;
    public int climbStairs(int n) {
        a = new int[n + 1];
        return fb(n);
    }

    private int fb(int n) {
        if (a[n] > 0) {
            return a[n];
        }
        if (n == 1 || n == 0) {
            return 1;
        }
        a[n] = fb(n - 1) + fb(n - 2);
        return a[n];
    }
}
//leetcode submit region end(Prohibit modification and deletion)

  }
