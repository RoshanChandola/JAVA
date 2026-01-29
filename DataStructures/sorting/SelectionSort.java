class SelectionSort {

    void selectionSort(int arr[]) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {

            int minIndex = i;  // index of the smallest element

            // Find the minimum element in the unsorted part
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            // Swap the found minimum element with the first element of unsorted part
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {

        int arr[] = {64, 25, 12, 22, 11};

        SelectionSort ss = new SelectionSort();
        ss.selectionSort(arr);

        System.out.println("Sorted array:");
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
// time Complexity: O(n^2)
// Space Complexity: O(1)
//best case: O(n^2)
//average case: O(n^2)
//worst case: O(n^2)
// in-place sorting algorithm : meaning it requires a constant amount O(1) of additional memory space
// not a stable sorting algorithm
//stable meaning that the relative order of equal elements is preserved
