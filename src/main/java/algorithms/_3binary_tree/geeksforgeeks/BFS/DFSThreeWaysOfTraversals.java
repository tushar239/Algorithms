package algorithms._3binary_tree.geeksforgeeks.BFS;

import algorithms._3binary_tree.geeksforgeeks.BinaryTree;
import algorithms.crackingcodinginterviewbook._4tree_and_graph.tree.baseclasses.TreeNode;
import algorithms.utils.TreeUtils;
import com.google.common.collect.Lists;

import java.util.List;
import java.util.Stack;

/**
 * https://www.baeldung.com/java-depth-first-search
 *
 *
 * There are three different orders for traversing a tree using DFS:
 *      Preorder Traversal
 *      Inorder Traversal
 *      Postorder Traversal
 *
 * The main difference between graphs and trees is that graphs may contain cycles.
 * So to avoid searching in cycles, we will mark each node when we visit it.
 * We’ll see two implementations for graph DFS, with recursion, and without recursion.
 */
public class DFSThreeWaysOfTraversals {
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1,2,3,4,5,6,7);
        BinaryTree binaryTree = new BinaryTree(TreeUtils.createBinaryTree(list, 0, list.size() - 1));
        TreeUtils.printPreety(binaryTree.getRoot());
        System.out.println("PreOrder traversal");
        traversePreOrderWithoutRecursion(binaryTree);
        System.out.println();
        System.out.println("InOrder traversal");
        traverseInOrderWithoutRecursion(binaryTree);
        System.out.println();
        System.out.println("PostOrder traversal");
        traversePostOrderWithoutRecursion(binaryTree);
        System.out.println();
    }
    private static void traversePreOrderWithoutRecursion(BinaryTree binaryTree) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = binaryTree.getRoot();
        stack.push(current);
        while(!stack.isEmpty()) {
            current = stack.pop();
            visit(current.data);

            if(current.right != null) {
                stack.push(current.right);
            }
            if(current.left != null) {
                stack.push(current.left);
            }
        }
    }
    private static void traverseInOrderWithoutRecursion(BinaryTree binaryTree) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = binaryTree.getRoot();

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            TreeNode top = stack.pop();
            visit(top.data);
            current = top.right;
        }
    }
    public static void traversePostOrderWithoutRecursion(BinaryTree binaryTree) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode root = binaryTree.getRoot();
        TreeNode prev = root;
        TreeNode current = root;
        stack.push(root);

        while (!stack.isEmpty()) {
            current = stack.peek();
            boolean hasChild = (current.left != null || current.right != null);
            boolean isPrevLastChild = (prev == current.right ||
                    (prev == current.left && current.right == null));

            if (!hasChild || isPrevLastChild) {
                current = stack.pop();
                visit(current.data);
                prev = current;
            } else {
                if (current.right != null) {
                    stack.push(current.right);
                }
                if (current.left != null) {
                    stack.push(current.left);
                }
            }
        }
    }
    public void traversePreOrderRecursive(TreeNode treeNode) {
        if (treeNode != null) {
            visit(treeNode.data);
            traversePreOrderRecursive(treeNode.left);
            traversePreOrderRecursive(treeNode.right);
        }
    }
    public void traverseInOrderRecursive(TreeNode treeNode) {
        if (treeNode != null) {
            traverseInOrderRecursive(treeNode.left);
            visit(treeNode.data);
            traverseInOrderRecursive(treeNode.right);
        }
    }
    public void traversePostOrderRecursion(TreeNode treeNode) {
        if (treeNode != null) {
            traversePostOrderRecursion(treeNode.left);
            traversePostOrderRecursion(treeNode.right);
            visit(treeNode.data);
        }
    }

    private static void visit(Integer data) {
        System.out.print(data+",");
    }


    /*
    We can also implement graph DFS without recursion. We’ll simply use a Stack:

        We’ll start from a given node
        Push start node into stack
        While Stack not empty
        Mark current node as visited
        Visit current node
        Push unvisited adjacent vertices

        public void dfsWithoutRecursion(int start) {
            Stack<Integer> stack = new Stack<Integer>();
            boolean[] isVisited = new boolean[adjVertices.size()];
            stack.push(start);
            while (!stack.isEmpty()) {
                int current = stack.pop();
                if(!isVisited[current]){
                    isVisited[current] = true;
                    visit(current);
                    for (int dest : adjVertices.get(current)) {
                        if (!isVisited[dest])
                            stack.push(dest);
                    }
            }
            return isVisited;
        }
     */

    /*
    First, let’s start simple with recursion:

        We’ll start from a given node
        Mark current node as visited
        Visit current node
        Traverse unvisited adjacent vertices


    private boolean[] dfsRecursive(int current, boolean[] isVisited) {
        isVisited[current] = true;
        visit(current);
        for (int dest : adjVertices.get(current)) {
            if (!isVisited[dest])
                dfsRecursive(dest, isVisited);
        }
        return isVisited;
    }
    public boolean[] dfs(int start) {
        boolean[] isVisited = new boolean[adjVertices.size()];
        return dfsRecursive(start, isVisited);
    }

    private boolean[] dfsRecursive(int current, boolean[] isVisited) {
        isVisited[current] = true;
        visit(current);
        for (int dest : adjVertices.get(current)) {
            if (!isVisited[dest])
                dfsRecursive(dest, isVisited);
        }
        return isVisited;
    }
    */


}
