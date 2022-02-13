package linkedlists;

public class MiddleOfLinkedList {

    public static int middleNode(Node start) {
        Node.LinkedList slowPtr = start.head, fastPtr = start.head;
        while(fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        if (slowPtr != null) {
            return slowPtr.getData();
        }
        return 0;
    }

    public static void main(String[] args) {

        Node node = new Node();
        node.append(1);
        node.append(2);
        node.append(3);
        node.append(4);
        node.append(5);
        node.append(6);

        node.printList();

        System.out.println("Middle Value : "+ middleNode(node));
    }

}
