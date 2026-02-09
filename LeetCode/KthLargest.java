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
//because minheap stores the smallest element at the top, we maintain a min heap of size k to keep track of the k largest elements seen so far. Whenever the size of the heap exceeds k, we remove the smallest element (the root of the min heap). At the end, the root of the min heap will be the kth largest element in the array. This approach has a time complexity of O(n log k) and a space complexity of O(k).

//dry run for optimized code
// Input: arr = [12, 3, 5, 7, 19], k = 4
// Output: 5    
// Explanation:
// We initialize an empty min heap.
// We iterate through the array:
// num = 12: Add 12 to the min heap => minHeap = [12]
// num = 3: Add 3 to the min heap => minHeap = [3, 12]
// num = 5: Add 5 to the min heap => minHeap = [3, 12, 5]
// num = 7: Add 7 to the min heap => minHeap = [3, 7, 5, 12]; size exceeds k, remove the smallest element (3) => minHeap = [5, 7, 12]
