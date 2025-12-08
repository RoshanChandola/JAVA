
public class Doubly_LL {
    class Node{
            int val;
            Node next;
            Node prev;
            Node(int val)
            {
                this.val=val;
                this.next=null;
                this.prev=null;
            }
    }
    Node head=null;
    void Insert_end(int val)
    {
        Node newnode=new Node(val);
        if(head==null){
            head=newnode;
            return;
        }
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newnode;
        newnode.prev=temp;
    }
    void insert_front(int val)
    {
        Node newnode=new Node(val);
        if(head==null)
        {
            head=newnode;
            return;
        }
        newnode.next=head;
        head.prev=newnode;
        head=newnode;
    }
    void delete(int key)
    {
        Node temp=head;
        if(head.val==key)
        {
            head=head.next;
            if(head!=null){
                head.prev=null;
            }
            return;
        }
        while(temp!=null&&temp.val!=key)
        {
            temp=temp.next;
        }
        if(temp==null)
        {
            return;
        }
        if(temp.next==null)
        {
            temp.prev.next=null;
            return;
        }
        else{
            temp.prev.next=temp.next;
            temp.next.prev=temp.prev;
        }
    }
    void display()
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.val+" ");
            temp=temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Doubly_LL dll=new Doubly_LL();
        dll.Insert_end(10);
        dll.Insert_end(20);
         dll.Insert_end(30);
          dll.Insert_end(65);
        dll.insert_front(5);
        dll.display();
        dll.delete(20);
        dll.display();
    }
}
