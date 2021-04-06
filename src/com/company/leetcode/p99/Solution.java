package com.company.leetcode.p99;

import com.company.leetcode.tools.binarytrees.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    Map<TreeNode, Return> cache = new HashMap<>();
    public void recoverTree(TreeNode root) {
        populateCache(root);

        finishedSwap(root);
    }

    private Return populateCache(TreeNode root) {
        if (root == null) {
            return null;
        }

        Return leftReturn = populateCache(root.left);
        Return rightReturn = populateCache(root.right);

        TreeNode selfMin;
        TreeNode selfMax;
        if (leftReturn == null && rightReturn == null) {
            selfMin = root;
            selfMax = root;
            Return r = new Return(selfMin, selfMax);
            cache.put(root, r);
            return r;
        }

        if (leftReturn == null) {
            if (rightReturn.min.val < root.val) {
                selfMin = rightReturn.min;
            } else {
                selfMin = root;
            }
            if (rightReturn.max.val > root.val) {
                selfMax = rightReturn.max;
            } else {
                selfMax = root;
            }
            Return r = new Return(selfMin, selfMax);
            cache.put(root, r);
            return r;
        }

        if (rightReturn == null) {
            if (leftReturn.min.val < root.val) {
                selfMin = leftReturn.min;
            } else {
                selfMin = root;
            }
            if (leftReturn.max.val > root.val) {
                selfMax = leftReturn.max;
            } else {
                selfMax = root;
            }
            Return r = new Return(selfMin, selfMax);
            cache.put(root, r);
            return r;
        }


        if (leftReturn.min.val <= rightReturn.min.val) {
            selfMin = leftReturn.min;
        } else {
            selfMin = rightReturn.min;
        }

        if (leftReturn.max.val <= rightReturn.max.val) {
            selfMax = leftReturn.max;
        } else {
            selfMax = rightReturn.max;
        }
        Return r = new Return(selfMin, selfMax);
        cache.put(root, r);
        return r;
    }

    private boolean finishedSwap(TreeNode root) {
        if (root != null) {
            Return r = cache.get(root);
            if (r.max != null && r.max.val < root.val) {
                if (r.min != null && r.min.val > root.val) {
                    int temp = r.max.val;
                    r.max.val = r.min.val;
                    r.min.val = temp;
                    return true;
                } else {
                    int temp = r.max.val;
                    r.max.val = root.val;
                    root.val = temp;
                    return true;
                }
            } else if (r.min != null && r.min.val > root.val) {
                int temp = r.min.val;
                r.min.val = root.val;
                root.val = temp;
                return true;
            } else {
                boolean swappedOnLeft = finishedSwap(root.left);
                if (!swappedOnLeft) {
                    return finishedSwap(root.right);
                }
            }
        }
        return false;
    }

    private static final class Return {
        TreeNode min;
        TreeNode max;
        Return(TreeNode min, TreeNode max) {
            this.min = min;
            this.max = max;
        }
    }


    /*

                  10
              5        12
          9                 50



     */
}
