package advance.trees.interviews;

import com.sun.source.tree.Tree;

class TreeNode {
     int value;
     TreeNode left;
     TreeNode right;

    TreeNode(int value, TreeNode left, TreeNode right){
        this.value = value;
        this.left = left;
        this.right = right;
    }

    TreeNode(int value){
        this.value = value;
    }
}
