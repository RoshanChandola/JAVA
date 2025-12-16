class Main {

    static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n; i++) {
            int j = i;

            while (j > 0 && arr[j] < arr[j - 1]) {
                // swap adjacent elements
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;

                j--;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {7, 5, 9, 1, 3};

        insertionSort(arr);

        for (int x : arr) {
            System.out.print(x + " ");
        }
    }
}
