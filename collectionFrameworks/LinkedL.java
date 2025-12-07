import java.util.*;
public class LinkedL {
    public static void main(String[] args) {
        List<Integer> list=new LinkedList<>();
        list.add(10);
        list.add(20);
        list.add(30);       
        System.out.println(list);
        list.addFirst(54);
        list.addLast(58);
        System.out.println(list);
        list.removeFirst();
        list.removeLast();
    } 
}                 //NOTES
//java has inbuilt LinkedList class in collection framework which implements List and Deque interfaces. It allows the storage of duplicate elements and maintains insertion order. It is a doubly linked list that provides better performance for add and remove operations compared to ArrayList, especially for large lists. It also allows null values and provides various methods for manipulating the list, such as adding, removing, and accessing elements.
//Some commonly used methods of LinkedList class are:               
//1. add(E e): Adds the specified element to the end of the list.
//2. addFirst(E e): Inserts the specified element at the beginning of the list.     
//3. addLast(E e): Appends the specified element to the end of the list.
//4. removeFirst(): Removes and returns the first element from the list.    
//5. removeLast(): Removes and returns the last element from the list.