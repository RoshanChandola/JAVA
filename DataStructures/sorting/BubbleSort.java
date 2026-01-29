
class BubbleSort {

    void bubbleSort(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        int arr[] = { 64, 34, 25, 12, 22, 11, 90 };

        BubbleSort bs = new BubbleSort();
        bs.bubbleSort(arr);

        System.out.println("Sorted array:");
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
// Time Complexity: O(n^2)
// Space Complexity: O(1)
// Best Case: O(n) (when the array is already sorted)
// Average Case: O(n^2)
// Worst Case: O(n^2) (when the array is sorted in reverse order)
// In-place sorting algorithm
// Stable sorting algorithm (preserves the relative order of equal elements)
