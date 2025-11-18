class Node
{
    int val;
    Node next;
    Node pre;
    Node(int val)
    {
        this.val=val;
        this.next=null;
        this.pre=null;
    }
}
class Double{
    Node head=null;

    void end(int val)
    {
        Node newnode=new Node(val);
        if(head==null)
        {
         head=newnode;
         return;
        }

         Node temp=head;
         while(temp.next!=null)
         {
             temp=temp.next;
         }
         temp.next=newnode;
         newnode.pre=temp;
    }
    void front(int val)
    {
        Node newnode=new Node(val);
        if(head==null)
        {
            head=newnode;
            return;
        }
        newnode.next=head;
        head.pre=newnode;
        head=newnode;
    }
    void delete(int key)
    {
        Node temp=head;
        if(head.val==key)
        {
            head=temp.next;
            if(head!=null)
            head.pre=null;
            return;
        }
        while(temp!=null&&temp.val!=key)
        {

            temp=temp.next;
        }
        if(temp==null)
        {
            System.out.println("key not found");
        }
        if(temp.next==null)
        {
            temp.pre.next=null;
        }
        temp.pre.next=temp.next;
        temp.next.pre=temp.pre;
    }
    void display()
    {
        Node temp=head;
        if(head==null)
        {
            System.out.println(" no element found");
            return;
        }
        while(temp!=null)
        {
            System.out.println(temp.val+" ");
            temp=temp.next;
        }
        System.out.println();
    }
     public static void main(String[]args) {
        Double  sll = new Double();

        // Insert elements
        sll.end(10);
        sll.end(20);
        sll.end(30);
        sll.front(5);

        // Display list
        sll.display();

        // Delete by value
        System.out.println("After deleting 20:");
        sll.delete(20);
        sll.display();

        // Try deleting a non-existent element
        System.out.println("After trying to delete 25:");
        sll.delete(25);
        sll.display();
    }

}

