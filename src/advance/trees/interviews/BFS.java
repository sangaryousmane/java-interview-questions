package advance.trees.interviews;

import com.sun.source.tree.Tree;

import java.util.*;

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
                subList.add(currentNode.value);

                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
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
    Answers within 10^5 of the actual answer will be accepted.
     */
    public List<Integer> sumOfLevels(TreeNode root) {
        List<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int sumOfAtLevel = 0;

            for (int i = 0; i < levelSize; i++) {
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

    // https://leetcode.com/problems/minimum-depth-of-binary-tree/description/
    public int minDepth(TreeNode root) {
        if (root == null) return 0;

        int left = minDepth(root.left) + 1;
        int right = minDepth(root.right) + 1;

        if (root.left != null) return right;
        if (root.right != null) return left;
        return Math.min(left, right);
    }

    // https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();

        if (root == null)
            return result;

        Deque<TreeNode> queue = new LinkedList<>();
        queue.offerFirst(root);
        boolean isReversed = false;

        while (!queue.isEmpty()) {
            int leveSize = queue.size();
            List<Integer> currenLevel = new ArrayList<>();

            for (int i = 0; i < leveSize; i++) {

                // If the tree is in a reversed order
                if (isReversed) {
                    TreeNode currentNode = queue.pollLast(); // remove last
                    currenLevel.add(currentNode.value);
                    if (currentNode.right != null)
                        queue.addFirst(currentNode.right);
                    if (currentNode.left != null)
                        queue.addFirst(currentNode.left);
                }
                // If the tree is in normal order
                else {
                    TreeNode currentNode = queue.pollFirst(); // remove first
                    currenLevel.add(currentNode.value);
                    if (currentNode.left != null)
                        queue.addLast(currentNode.left);
                    if (currentNode.right != null)
                        queue.addLast(currentNode.right);
                }
            }
            isReversed = !isReversed;
            result.add(currenLevel);
        }
        return result;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;

        // The function will return -1 when it is unbalanced
        if (Height(root) == -1)
            return false;

        return true;
    }

    // https://leetcode.com/problems/balanced-binary-tree/
    private int Height(TreeNode root) {
        if (root == null)
            return 0;

        int left = Height(root.left);
        int right = Height(root.right);

        if (left == -1 || right == -1)
            return -1;

        if (Math.abs(left - right) > 1)
            return -1;

        return Math.max(left, right) + 1;
    }

    // https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
                subList.add(currentNode.value);

                if (currentNode.left != null)
                    queue.offer(currentNode.left);
                if (currentNode.right != null)
                    queue.offer(currentNode.right);
            }
            result.add(0, subList);
        }
        return result;
    }

    // https://leetcode.com/problems/maximum-depth-of-binary-tree/
    // Depth First Search
    public int maxDepth(TreeNode root) {
        // Max depth means the number of nodes from root to the farthest node.
        if (root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        return Math.max(left, right) + 1;
    }

    // https://leetcode.com/problems/binary-tree-right-side-view/description/
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int level=queue.size();

            for (int i= 0; i< level; i++){
                TreeNode current= queue.poll();
                if (i == level - 1)
                    result.add(current.value);

                if (current.left != null)
                    queue.offer(current.left);
                if (current.right != null)
                    queue.offer(current.right);
            }
        }
        return result;
    }
}
