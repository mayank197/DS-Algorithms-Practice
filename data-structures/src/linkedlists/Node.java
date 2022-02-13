package linkedlists;

public class Node {

    LinkedList head;

    static class LinkedList {
        private int data;
        LinkedList next;

        public LinkedList(int data) {
            this.data = data;
            this.next = null;
        }

        public int getData() {
            return data;
        }
    }

    // Push to beginning
    public void push(int val){
        LinkedList newNode = new LinkedList(val);
        if (head != null) {
            newNode.next = head;
        } else {
            head = newNode;
        }
    }

    // Insert after a specific node
    public void insertAfter(LinkedList prevNode, int val){
        if(prevNode == null){
            throw new Error("No node given");
        }
        LinkedList newLinkedList = new LinkedList(val);
        // Set next of new node to given node's next
        newLinkedList.next = prevNode.next;
        // Break existing link
        prevNode.next = newLinkedList;
    }

    // Appends at end
    public void append(int val) {
        LinkedList newNode = new LinkedList(val);
        if (head == null) {
            head = newNode;
            return;
        }
        // Get to last of current linked list
        LinkedList curr = head;
        while(curr != null && curr.next != null){
            curr = curr.next;
        }
        curr.next = newNode;
    }

    public void printList() {
        LinkedList curr = head;
        System.out.print("List : ");
        while (curr != null) {
            System.out.print(curr.data + "->");
            curr = curr.next;
        }
        System.out.println("END");
    }

    public int listLength() {
        int count = 0;
        LinkedList curr = head;
        while(curr != null) {
            count ++;
            curr = curr.next;
        }
        return count;
    }
}
