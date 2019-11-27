package rmugattarov.tree;

public class BinaryTree {
    Node root;
    int size;

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.add(5);
        tree.add(2);
        tree.add(7);
        tree.add(9);
        System.out.println(tree);
        System.out.println(tree.contains(0));
        System.out.println(tree.contains(5));
        System.out.println(tree.contains(9));
        System.out.println(tree.contains(10));
        tree.visitInOrder();
    }

    public void visitInOrder() {
        visitInOrder(root);
    }

    private void visitInOrder(Node n) {
        if (n != null) {
            visitInOrder(n.left);
            System.out.println(n);
            visitInOrder(n.right);
        }

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
