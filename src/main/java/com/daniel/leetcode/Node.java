package com.daniel.leetcode;

import java.util.List;

/**
 * @author daniel 2021/11/30 3:11 PM
 */
public class Node {
		public int val;
		public List<Node> children;

		public Node() {
		}

		public Node(int _val) {
			val = _val;
		}

		public Node(int _val, List<Node> _children) {
			val = _val;
			children = _children;
		}
}
