package rmugattarov.tree;

import java.util.Arrays;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class BinaryTree {
    Node root;
    int size;

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add(5);
        tree.add(2);
        tree.add(7);
        tree.add(9);
        tree.add(11);
        System.out.println(tree);
        System.out.println(tree.contains(0));
        System.out.println(tree.contains(5));
        System.out.println(tree.contains(9));
        System.out.println(tree.contains(10));
        tree.visitInOrder();
        tree.listLevels();
    }

    public void visitInOrder() {
        System.out.println("Visiting in order");
        visitInOrder(root);
    }

    private void visitInOrder(Node n) {
        if (n != null) {
            visitInOrder(n.left);
            System.out.println(n);
            visitInOrder(n.right);
        }

    }

    public void listLevels() {
        System.out.println("Listing levels");
        List<Node> nextLevel = Arrays.asList(root);
        while (!nextLevel.isEmpty()) {
            System.out.println(nextLevel);
            nextLevel = listNextLevel(nextLevel);
        }
    }

    private List<Node> listNextLevel(Collection<Node> nodes) {
        List<Node> res = new LinkedList<>();
        for (Node n : nodes) {
            if (n.left != null) res.add(n.left);
            if (n.right != null) res.add(n.right);
        }
        return res;
    }

    public boolean contains(int i) {
        if (root == null) {
            return false;
        } else {
            return contains(root, i);
        }
    }

    private boolean contains(Node n, int i) {
        if (n == null) return false;
        if (n.val == i) return true;
        else if (n.val < i) return contains(n.right, i);
        else return contains(n.left, i);
    }

    public void add(int i) {
        if (root == null) {
            root = new Node();
            root.val = i;
            size = 1;
        } else {
            add(root, i);
        }
    }

    private void add(Node n, int i) {
        if (n.val <= i) {
            if (n.right == null) {
                n.right = new Node();
                n.right.val = i;
            } else {
                add(n.right, i);
            }
        } else {
            if (n.left == null) {
                n.left = new Node();
                n.left.val = i;
            } else {
                add(n.left, i);
            }
        }
    }

    @Override
    public String toString() {
        return root.toString();
    }

    static class Node {
        int val;
        Node left;
        Node right;

        @Override
        public String toString() {
            return "{" + val + "," + left + "," + right + "}";
        }
    }
}
