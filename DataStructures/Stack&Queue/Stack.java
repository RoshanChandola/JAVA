public class Stack {
    int top,max;
    int stack[];
    Stack(int size)
    {
        this.max=size;
        top=-1;
        stack=new int[size];
    }
    void pust(int val)
    {
        if(top==max-1)
        {
            System.out.println("Stack Overflow");
            return;
        }
        stack[++top]=val;
        System.out.println(val+" is pushed to stack");
    }
    int pop()
    {
        if(top==-1)
        {
            System.out.println("Stack Underflow");
            return -1;
        }
        return stack[top--];
    }
    int peek()
    {
        if(top==-1)
        {
            System.out.println("Stack is empty");
            return -1;
        }
        return stack[top];
    }
    void display()
    {
        if(top==-1)
        {
            System.out.println("Stack is empty");
            return;
        }
        System.out.print("Stack elements: ");
        for(int i=top;i>=0;i--)
        {
            System.out.print(stack[i]+" ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Stack s=new Stack(5);
        s.pust(10);
        s.pust(20);
        s.pust(30);
        s.display();
        System.out.println("Top element is: "+s.peek());
        System.out.println(s.pop()+" is popped from stack");
        s.display();
    }
}
