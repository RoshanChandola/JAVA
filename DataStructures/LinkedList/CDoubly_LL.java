class CDoubly_LL {

    // Node structure
    class Node {
        int data;
        Node next, prev;

        Node(int data) {
            this.data = data;
        }
    }

    Node head = null;

    // Insert at beginning
    void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            Node last = head.prev;

            newNode.next = head;
            newNode.prev = last;

            last.next = newNode;
            head.prev = newNode;

            head = newNode;
        }
    }

    // Insert at end
    void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            Node last = head.prev;

            newNode.next = head;
            newNode.prev = last;

            last.next = newNode;
            head.prev = newNode;
        }
    }

    // Delete first node
    void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.next == head) { // Only one node
            head = null;
        } else {
            Node last = head.prev;
            head = head.next;

            head.prev = last;
            last.next = head;
        }
    }

    // Delete last node
    void deleteLast() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.next == head) { // only one node
            head = null;
        } else {
            Node last = head.prev;
            Node secondLast = last.prev;

            secondLast.next = head;
            head.prev = secondLast;
        }
    }

    // Traverse list
    void display() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        Node temp = head;
        do {
            System.out.print(temp.data + " ");
            temp = temp.next;
        } while (temp != head);

        System.out.println();
    }

    // MAIN
    public static void main(String[] args) {
        CDoubly_LL list = new CDoubly_LL();

        list.insertAtBeginning(10);
        list.insertAtBeginning(20);
        list.insertAtEnd(5);
        list.insertAtEnd(1);

        System.out.println("List after insertions:");
        list.display();

        list.deleteFirst();
        System.out.println("After deleting first:");
        list.display();

        list.deleteLast();
        System.out.println("After deleting last:");
        list.display();
    }
}
