package rmugattarov.linkedlist;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindMiddle {
    public static void main(String[] args) {
        List<Node> nodes = IntStream.range(0, 23)
                .mapToObj(i -> {
                    Node n = new Node();
                    n.val = i;
                    return n;
                })
                .collect(Collectors.toList());
        for (int i = 0; i < nodes.size() - 1; i++) {
            nodes.get(i).next = nodes.get(i + 1);
        }
        System.out.println(nodes);
        findMid(nodes.get(0));
    }

    private static void findMid(Node n) {
        Node mid = n;
        int count = 0;
        while (n.next != null) {
            n = n.next;
            if ((count++ & 1) == 0) mid = mid.next;
        }
        System.out.println(mid);
    }

    private static class Node {
        int val;
        Node next;

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
