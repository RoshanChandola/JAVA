class KthLargest {
    public static void main(String[] args) {
        int[] arr = {12, 3, 5, 7, 19};
        int k = 4;
        int n = arr.length;

        for (int i = 0; i < k; i++) {
            int maxIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }

            // swap
            int temp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = temp;
        }

        System.out.println(k + "th largest element is " + arr[k - 1]);
    }
}
//dry run
// Input: arr = [12, 3, 5, 7, 19], k = 4
// Output: 5   
// Explanation:
// Initially, arr = [12, 3, 5, 7, 19]
// i = 0: maxIndex = 0; j iterates from 1 to 4, finds maxIndex = 4 (19); swap arr[0] and arr[4] => arr = [19, 3, 5, 7, 12]
// i = 1: maxIndex = 1; j iterates from 2 to 4, finds maxIndex = 4 (12); swap arr[1] and arr[4] => arr = [19, 12, 5, 7, 3]
// i = 2: maxIndex = 2; j iterates from 3 to 4, finds maxIndex = 3 (7); swap arr[2] and arr[3] => arr = [19, 12, 7, 5, 3]
// i = 3: maxIndex = 3; j iterates from 4 to 4, maxIndex remains 3 (5); no swap needed => arr = [19, 12, 7, 5, 3]
// The 4th largest element is arr[3] = 5    
// Final Output: 5
// Time Complexity: O(n*k) where n is the number of elements in the array and k is the kth largest element to find.
// Space Complexity: O(1) as we are using constant extra space.
// The code finds the kth largest element in an unsorted array by performing k iterations of selection sort to place the largest k elements at the beginning of the array.
//the optimized way is to use min heap or quickselect algorithm
//code for optized code is below 
/*import java.util.PriorityQueue;
class KthLargestOptimized {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }

    public static void main(String[] args) {
        int[] arr = {12, 3, 5, 7, 19};
        int k = 4;

        KthLargestOptimized kl = new KthLargestOptimized();
        int result = kl.findKthLargest(arr, k);
        System.out.println(k + "th largest element is " + result);
    }
}*/
