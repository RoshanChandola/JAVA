public class exception{
    public static void main(String[] args) {
        try {
            int arr[] = {1, 2, 3, 4};
            System.out.println(arr[3]);  // outer try will catch this

            try {
                int x = 10 / 0;  // inner try
            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Inner catch: " + e);
            }
        } catch (ArithmeticException e) {
            System.out.println("Outer catch: " + e);
        }

        System.out.println("Program ends normally...");
    }
}

