package advance.trees.interviews;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    // https://leetcode.com/problems/binary-tree-level-order-traversal/
    public List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            // Get the current level list(the list at each level of the tree)
            List<Integer> subList = new ArrayList<>(levelSize);

            // Loop through the level
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                if (currentNode != null) {
                    subList.add(currentNode.value);

                    if (currentNode.left != null)
                        queue.offer(currentNode.left);
                    if (currentNode.right != null)
                        queue.offer(currentNode.right);
                }

            }
            result.add(subList);
        }
        return result;
    }

    // https://leetcode.com/problems/average-of-levels-in-binary-tree/description/
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result = new ArrayList<>();

        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            double averageOfEachLevel = 0;

            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll(); // the head or top node
                averageOfEachLevel += currentNode.value;

                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }
            averageOfEachLevel /= levelSize;
            result.add(averageOfEachLevel);
        }
        return result;
    }

    /*
    Given the root of a binary tree,
    return the sum value of the nodes on each level in the form of an array.
    Answers within 10-5 of the actual answer will be accepted.
     */
    public List<Integer> sumOfLevels(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            int levelSize=queue.size();
            int sumOfAtLevel = 0;

            for (int i=0; i < levelSize; i++){
                TreeNode currentNode = queue.poll(); // the topmost node
                sumOfAtLevel += currentNode.value;

                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }
            result.add(sumOfAtLevel);
        }
        return result;
    }
}
