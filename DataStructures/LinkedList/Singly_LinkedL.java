
class Singly_LinkedL{
    class Node{
        int val;
        Node next;
        Node(int val)
        {
            this.val=val;
            this.next=null;
        }
   }
    Node head=null;
    void end(int val)
    {
         Node newnode=new Node(val);
        if(head==null)
        {
            head=newnode;
            return;
        }
        else{
           
            Node temp=head;
            while(temp.next!=null)
            {
                temp=temp.next;
            }
            temp.next=newnode;
        }
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
         head=newnode;
    }
    void delete_end(int key)
    {
        Node temp=head;
        Node prev=null;
        if (temp.next!=null&&temp.val==key)
        {
            head=temp.next;
            return;
        }
        while(temp!=null&&temp.val!=key)
        {
            prev=temp;
            temp=temp.next;
        }
        if(temp==null)
        {
            return;
        }
        prev.next=temp.next;
        

    }
    void display(){
        Node temp=head;
        while(temp!=null)
        {
            System.out.println(temp.val);
            temp=temp.next;
        }
    }
    public static void main(String[] args) {
        Singly_LinkedL sll=new Singly_LinkedL();
        sll.end(10);
        sll.end(20);
        sll.end(30);
        sll.front(5);
        sll.display();
        System.out.println("After deletion");
        sll.delete_end(25);
        sll.display();
        
    }
    
}