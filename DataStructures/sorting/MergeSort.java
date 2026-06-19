import java.util.ArrayList;

class MergeSort {

    // Function to merge two sorted halves
    void merge(int arr[], int low, int mid, int high) {// n = 6, low = 0, mid = 2, high = 5

        ArrayList<Integer> List = new ArrayList<>();
        int i = low;
        int j = mid + 1;
        while (i <= mid && j <= high) {
            if (arr[i] <= arr[j]) {
                List.add(arr[i]);
                i++;
            } else {
                List.add(arr[j]);
                j++;
            }
        }
        while(i <= mid) {
            List.add(arr[i]);
            i++;
        }
        while(j <= high) {
            List.add(arr[j]);
            j++;
        }

        // Copy data into temporary arrays
       

        // Merge the two arrays back into arr[]
        
        

        for (int k = low; k <= high; k++) {
            arr[k] = List.get(k - low);
        }
    }

    // Merge Sort recursive function
    void mergeSort(int arr[], int low, int high) {

        if (low < high) {
            int mid = (low + high) / 2;

            mergeSort(arr, low, mid);   // Sort low half
            mergeSort(arr, mid + 1, high); // Sort high half

            merge(arr, low, mid, high);  // Merge the halves
        }
    }

    // Main method
    public static void main(String[] args) {

        int arr[] = {12, 11, 13, 5, 6, 7};// n = 6

        MergeSort ms = new MergeSort();
        ms.mergeSort(arr, 0, arr.length - 1);

        System.out.println("Sorted array:");
        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
