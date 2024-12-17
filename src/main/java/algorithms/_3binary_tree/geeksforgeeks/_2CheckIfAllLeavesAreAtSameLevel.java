package algorithms._3binary_tree.geeksforgeeks;

import algorithms.crackingcodinginterviewbook._4tree_and_graph.tree.baseclasses.TreeNode;
import algorithms.utils.TreeUtils;

import java.util.ArrayList;
import java.util.List;

/*
    Check if all leaves are at same level

    https://www.geeksforgeeks.org/check-leaves-level/

    Solution:
    Find the level of first leaf node that you encounter during level order traversal
    and then compare the level of other leaf nodes with it.

*/
public class _2CheckIfAllLeavesAreAtSameLevel {

    public static void main(String[] args) {

        TreeNode one = createTree();

        System.out.print("Input Binary Tree:");
        TreeUtils.printPreety(one);

        _2CheckIfAllLeavesAreAtSameLevel obj = new _2CheckIfAllLeavesAreAtSameLevel();

        System.out.println("Approach 1.................");
        one = createTree();
        {
            boolean result = checkLeafNodes(one, 0, new ArrayList<>());
            System.out.println("Result: " + result); // true
        }
        {
            one.right.right.left = null; // seven.left=null
            one.right.right.right = null; // seven.right=null
            TreeUtils.printPreety(one);
            boolean result = checkLeafNodes(one, 0, new ArrayList<>());
            System.out.println("Result: " + result); // false
        }
        System.out.println("Approach 2.................");
        one = createTree();
        {

            boolean result = checkLeafNodes2(one, 0, -1);
            System.out.println("Result: " + result); // true
        }
        {
            one.right.right.left = null; // seven.left=null
            one.right.right.right = null; // seven.right=null
            TreeUtils.printPreety(one);
            boolean result = checkLeafNodes2(one, 0, -1);
            System.out.println("Result: " + result); // false
        }

         /*
         System.out.println("Approach 3.................");
         one = createTree();
        {
            boolean result = obj.check(one, 0);
            System.out.println("Result: " + result);// true
        }

        {
            seven.right = null;

            boolean result = obj.check(one, 0);
            System.out.println("Result: " + result);// false
        }*/
    }
    private static TreeNode createTree() {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight = new TreeNode(8);
        TreeNode nine = new TreeNode(9);
        TreeNode ten = new TreeNode(10);
        TreeNode eleven = new TreeNode(11);
        TreeNode twelve = new TreeNode(12);
        TreeNode thirteen = new TreeNode(13);

        one.left = two;
        one.right = three;

        two.left = four;
        two.right = five;

        three.left = six;
        three.right = seven;

        four.right = eight;

        five.left = nine;
        five.right = ten;

        six.left = eleven;
        six.right = twelve;

        seven.right = thirteen;
        return one;
    }

    /*
        Do not get confused seeing level passed in method. It alone doesn't make this traversal as level order traversal.
        It is still PreOrder traversal. Level is passed just to keep track of leaf node's level.
    */
    private int firstLeafNodeLevel = -1;

    private boolean check(TreeNode root, int level) {
        if (root == null) {
            return true;
        }

        if (isLeaf(root)) {
            // Find the level of first leaf node that you encounter during level order traversal
            if (firstLeafNodeLevel == -1) {
                firstLeafNodeLevel = level;
                return true;
            }
            // compare the level of other leaf nodes with firstLeafNodeLevel.
            if (level != firstLeafNodeLevel) {
                return false;
            }
            return true;

        }

        boolean areAllLeafNodesInLeftSubTreeAreAtSameLevel = check(root.left, level + 1);

        if (areAllLeafNodesInLeftSubTreeAreAtSameLevel) {
            boolean areAllLeafNodesInRightSubTreeAreAtSameLevel = check(root.right, level + 1);
            return areAllLeafNodesInRightSubTreeAreAtSameLevel;
        }
        return areAllLeafNodesInLeftSubTreeAreAtSameLevel;
    }

    private static boolean isLeaf(TreeNode root) {
        return root != null && root.left == null && root.right == null;
    }

    private static boolean checkLeafNodes(TreeNode root, int level, List<Integer> levels) {
        if(root == null || (root.left == null && root.right == null)) {
            return true;
        }
        if(root.left != null) {
            if(isLeaf(root.left)) {
                levels.add(level+1);
            }
        }
        if(!checkAllLevelsSame(levels)) {
            return false;
        }

        boolean left = checkLeafNodes(root.left, level+1, levels);

        if(root.right != null) {
            if(isLeaf(root.right)) {
                levels.add(level+1);
            }
        }
        if(!checkAllLevelsSame(levels)) {
            return false;
        }

        boolean right = checkLeafNodes(root.right, level+1, levels);

        return left && right;
    }
    private static boolean checkAllLevelsSame(List<Integer> leafLevels) {
        if(leafLevels.size() == 0 || leafLevels.size() == 1) {
            return true;
        }
        int first = leafLevels.get(0);
        for (Integer leafLevel : leafLevels) {
            if(leafLevel != first) {
                return false;
            }
        }
        return true;
    }
    private static boolean checkLeafNodes2(TreeNode root, int level, int prevLeafLevel) {
        if(root == null || (root.left == null && root.right == null)) {
            prevLeafLevel = level;
            return true;
        }
        level++;
        TreeNode node = root.left;
        //boolean leftNull = true;
        if(node != null) {
            //leftNull = false;
            //level = level+1;
            if(isLeaf(node)) {
                if (prevLeafLevel != -1) {
                    if (prevLeafLevel != level) {
                        return false;
                    }
                } else {
                    prevLeafLevel = level;
                }

            } /*else {
                prevLeafLevel = level;
            }*/
        }
        node = root.right;
        if(node != null) {
            //if(leftNull) {
                //level = level+1;
            //}
            if(isLeaf(node)) {
                if (prevLeafLevel != -1) {
                    if (prevLeafLevel != level) {
                        return false;
                    }
                } else {
                    prevLeafLevel = level;
                }
            }/* else {
                prevLeafLevel = level;
            }*/
        }
        return checkLeafNodes2(root.left, level, prevLeafLevel) && checkLeafNodes2(root.right, level, prevLeafLevel);
    }
}
