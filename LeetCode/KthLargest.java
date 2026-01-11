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
