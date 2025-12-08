public class InsertionSort {
    
    void insertionSort(int arr[]) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements that are greater than key one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key; // Insert key into correct position
        }
    }

    public static void main(String[] args) {

        int arr[] = { 12, 11, 13, 5, 6 };

        InsertionSort is = new InsertionSort();
        is.insertionSort(arr);

        System.out.println("Sorted array:");
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }

}
