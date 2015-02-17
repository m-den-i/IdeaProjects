import java.util.ArrayList;

/**
 * Created by Денис on 17.02.2015.
 */
class Tree{
    class TreeNode{
        boolean isLeft;
        int key;
        int height;
        TreeNode left;
        TreeNode right;
        TreeNode parent;
    }
    TreeNode head;
    ArrayList<ArrayList<TreeNode>> line;
    int height, case_;
    public Tree(int key){
        head = new TreeNode();
        head.key = key;
        head.height = 0;
        height = 0;
        head.left = null;
        head.right = null;
        line = new ArrayList<ArrayList<TreeNode>>();
        line.add(new ArrayList<TreeNode>());
        line.get(0).add(head);
    }
    public void addNode(TreeNode tree, int key){
        if (key < tree.key) {
            if (tree.left == null){
                tree.left = createNode(tree, key);
                tree.left.isLeft = true;
            }
            else addNode(tree.left, key);
        }
        else
        if (tree.right == null){
            tree.right = createNode(tree, key);
            tree.right.isLeft = false;
        }
        else addNode(tree.right, key);
    }
    private TreeNode createNode (TreeNode par, int key){
        TreeNode newNode;
        newNode = new TreeNode();
        newNode.height = par.height + 1;
        if (height < newNode.height) {
            height = newNode.height;
            line.add(new ArrayList<TreeNode>());
            line.get(height).add(newNode);
        }
        else {
            line.get(newNode.height).add(newNode);
        }
        newNode.left = null;
        newNode.right = null;
        newNode.parent = par;
        newNode.key = key;
        return newNode;
    }
    public void rightDelete(TreeNode node){
        if (node.right != null){
            redefine(node, minRight(node.right));
        }
        else {
            if (node.left != null){
                redefine(node, maxLeft(node.left));
            }
            else{
                redefine(node, null);
            }
        }
    }
    private
    private TreeNode minRight(TreeNode node){
        if (node.left != null) minRight(node.left);
        else {
            redefine(node, null);
            return node;
        }
    }
}
public class Main {
    public static void main(String [] args){

    }
}
