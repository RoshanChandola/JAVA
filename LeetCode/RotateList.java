//leetcode question url: https://leetcode.com/problems/rotate-list/ id=61
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        int n = 1;
        ListNode tail = head;

        // find length and tail
        while (tail.next != null) {
            tail = tail.next;
            n++;
        }

        k = k % n;
        if (k == 0) return head;

        // 🔑 make list circular
        tail.next = head;

        int steps = n - k;
        ListNode newTail = head;

        for (int i = 1; i < steps; i++) {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null; 

        return newHead;
    }
}

public class RotateList {
    public static void main(String[] args) {    
        Solution solution = new Solution();
        
        // Example usage:
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        
        int k = 2;
        
        ListNode rotatedList = solution.rotateRight(head, k);
        
        // Print rotated list
        ListNode current = rotatedList;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
