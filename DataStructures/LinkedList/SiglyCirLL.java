class SiglyCirLL {

    // Node structure
    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

    // Insert at beginning
    void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = head; // circular link
        } else {
            Node temp = head;

            // reach last node
            while (temp.next != head) {
                temp = temp.next;
            }

            temp.next = newNode;
            newNode.next = head;
            head = newNode;
        }
    }

    // Insert at end
    void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = head;
        } else {
            Node temp = head;

            // reach last node
            while (temp.next != head) {
                temp = temp.next;
            }

            temp.next = newNode;
            newNode.next = head;
        }
    }

    // Delete first node
    void deleteFirst() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.next == head) { // only one node
            head = null;
            return;
        }

        Node temp = head;

        // reach last node
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = head.next;
        head = head.next;
    }

    // Delete last node
    void deleteLast() {
        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        if (head.next == head) { // only one node
            head = null;
            return;
        }

        Node prev = null;
        Node temp = head;

        // reach last node
        while (temp.next != head) {
            prev = temp;
            temp = temp.next;
        }

        prev.next = head;  // delete last node
    }

    // Display list
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

    // MAIN FUNCTION
    public static void main(String[] args) {
        SiglyCirLL list = new SiglyCirLL();

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

