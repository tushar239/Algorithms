package algorithms._3binary_tree.geeksforgeeks.BFS;

import algorithms._3binary_tree.geeksforgeeks.BinaryTree;
import algorithms.crackingcodinginterviewbook._4tree_and_graph.tree.baseclasses.TreeNode;
import algorithms.utils.TreeUtils;
import com.google.common.collect.Lists;

import java.util.ArrayDeque;
import java.util.List;
import java.util.Queue;

/**
 * https://www.baeldung.com/java-breadth-first-search#bd-java-trees
 *
 *
 */
public class BFSLevelOrderTraversal {
    public static void main(String[] args) {
        List<Integer> list = Lists.newArrayList(1,2,3,4,5,6,7);
        BinaryTree binaryTree = new BinaryTree(TreeUtils.createBinaryTree(list, 0, list.size() - 1));
        TreeUtils.printPreety(binaryTree.getRoot());
        System.out.println("LevelOrder traversal");
        levelOrderTraversal(binaryTree, 7);
        System.out.println();
    }
    private static void levelOrderTraversal(BinaryTree binaryTree, int data) {
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(binaryTree.getRoot());

        TreeNode currentNode;

        while (!queue.isEmpty()) {
            currentNode = queue.remove();
            visit(currentNode.data);
            if(currentNode.left != null) {
                queue.add(currentNode.left);
            }
            if(currentNode.right != null) {
                queue.add(currentNode.right);
            }

            /*if (currentNode.data.equals(data)) {
                System.out.println(data +" found");
            } else {
               queue.add(currentNode.left);
               queue.add(currentNode.right);
            }*/
        }
    }
    private static void visit(Integer data) {
        System.out.print(data+",");
    }
    /*
        For graph: graph can have cycles. So, we must check whether the node is already visited.

        public static <T> Optional<Node<T>> search(T value, Node<T> start) {
            while (!queue.isEmpty()) {
                currentNode = queue.remove();
                LOGGER.debug("Visited node with value: {}", currentNode.getValue());

                if (currentNode.getValue().equals(value)) {
                    return Optional.of(currentNode);
                } else {
                    alreadyVisited.add(currentNode);
                    queue.addAll(currentNode.getNeighbors());
                    queue.removeAll(alreadyVisited);
                }
            }

            return Optional.empty();
        }


     */

}
