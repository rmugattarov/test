package rmugattarov.crack;

import lombok.Data;

import java.util.*;

public class BreadthFirstSearch {
    public static void main(String[] args) {
        Node root = new Node("root");
        Node l1_1 = new Node("l1_1");
        Node l1_2 = new Node("l1_2");
        Node l2_1 = new Node("l2_1");
        Node l2_2 = new Node("l2_2");
        root.children.add(l1_1);
        root.children.add(l1_2);
        l1_1.children.add(l2_1);
        l1_1.children.add(l2_2);

        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(root);
        System.out.println(contains(l2_2, queue));
    }

    @Data
    private static class Node {
        private String name;
        private List<Node> children = new ArrayList<>();

        public Node(String name) {
            this.name = name;
        }
    }

    private static boolean contains(Node target, Queue<Node> queue) {
        if (queue.size() == 0) {
            return false;
        }
        Node head = queue.remove();
        System.out.println("Head : " + head);
        if (head == target) {
            return true;
        }
        queue.addAll(head.children);
        if (queue.size() == 0) {
            return false;
        }
        return contains(target, queue);
    }
}
