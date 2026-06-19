public class QuickSort {

    static int partition(int[] arr, int low, int high) {//array: [34, 7, 23, 32, 5, 62], low: 0, high: 5
        int pivot = arr[low];// pivot: 34
        int i = low;
        int j = high;

        while (i < j) {
            while (arr[i] <= pivot && i < high) i++; // find element greater than pivot: i will stop at 62
            while (arr[j] > pivot && j > low) j--; // find element less than or equal to pivot: j will stop at 5
            if (i < j) {
                swap(arr, i, j);
            }
            
        }

        // place pivot in correct position
        swap(arr, low, j);

        return j;  // return pivot index
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) {   // base condition
            int pivotIndex = partition(arr, low, high);
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    public static void main(String[] args) {
        int[] arr = {34, 7, 23, 32, 5, 62};
        quickSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");
        for (int num : arr) {
            System.out.print(num + " ");
        } 
    }
}
