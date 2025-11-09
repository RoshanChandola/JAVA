public class Queue {
    int size, front,rear;
    int Queue[];
    Queue(int n)
    {
        size=n;
        front=0;
        rear=-1;
        Queue=new int[size];
    }
    void enqueue(int val)
    {
        if(rear==size-1)
        {
            System.out.println("Queue is full");
            return;
        }
        rear++;
        Queue[rear]=val;
        System.out.println(val+" is enqueued");
    }
    void dequeue()
    {
        if(front>rear)
        {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println(Queue[front]+" is dequeued");
        front++;
    }
    void peek()
    {
        if(front>rear)
        {
            System.out.println("Queue is empty");
            return;
        }
        System.out.println("Front element is: "+Queue[front]);
    }
    void display()
    {
        if(front>rear)
        {
            System.out.println("Queue is empty");
            return;
        }
        System.out.print("Queue elements: ");
        for(int i=front;i<=rear;i++)
        {
            System.out.print(Queue[i]+" ");
        }
        System.out.println();
}
    public static void main(String[] args) {
        Queue q=new Queue(5);
        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);
        q.display();
        q.peek();
        q.dequeue();
        q.display();
    }
}
