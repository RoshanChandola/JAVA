// leetcode problem : merge two sorted Linked lists url: https://leetcode.com/problems/merge-two-sorted-lists/ description: Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists. question id: 21

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }

    }
}
public class MergeSortedList {
    public static void main(String[] args) {
        // Example usage:
        ListNode l1 = new ListNode(1, new ListNode(3, new ListNode(5)));
        ListNode l2 = new ListNode(2, new ListNode(4, new ListNode(6)));
        Solution solution = new Solution();
        ListNode mergedList = solution.mergeTwoLists(l1, l2);

        // Print merged list
        ListNode current = mergedList;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
