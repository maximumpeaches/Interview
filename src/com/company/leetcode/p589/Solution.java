package com.company.leetcode.p589;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution {

    private static final class Node {
        public int val;
        public List<Node> children;

        public Node() {}

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, List<Node> children) {
            this.val = val;
            this.children = children;
        }
    };

    // iterative solution:
    public List<Integer> preorder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Deque<Node> stack = new ArrayDeque<>();
        stack.addFirst(root);
        List<Integer> result = new ArrayList<>();
        while (!stack.isEmpty()) {
            Node current = stack.removeFirst();
            result.add(current.val);
            for (int i = current.children.size() - 1; i >= 0; i--) {
                Node child = current.children.get(i);
                if (child != null) {
                    stack.addFirst(child);
                }
            }
        }
        return result;
    }

    /*
    Recursive solution:
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        recursiveCall(root, result);
        return result;
    }

    private void recursiveCall(Node root, List<Integer> result) {
        if (root != null) {
            result.add(root.val);
            for (Node child : root.children) {
                recursiveCall(child, result);
            }
        }
    }
     */
}
