public class Circular_Queue {
    int size,front,rear,current_size;
    int Queue[];
    Circular_Queue(int size)
    {
        this.size=size;
        current_size=0;
        front=0;
        rear=-1;
        Queue=new int[size];
    }
    void enqueue(int val)
    {
        if(current_size==size)
        {
            System.out.println("Queue is full");
            return;
        }
        rear=(rear+1)%size;
        Queue[rear]=val;
        current_size++;
        System.out.println(val+" is enqueued");
    }
    void dequeue()
    {
        if(current_size==0)
        {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println(Queue[front]+" is dequeued");
        front=(front+1)%size;
        current_size--;
    }
    void peek()
    {
        if(current_size==0)
        {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Front element is: "+Queue[front]);
    }
    void display()
    {
        if(current_size==0)
        {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue elements: ");
        for(int i=0;i<current_size;i++)
        {
            System.out.print(Queue[(front+i)%size]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Circular_Queue cq=new Circular_Queue(5);
        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.display();
        cq.peek();
        cq.dequeue();
        cq.display();
    }
}
