import java.util.Scanner;


 public class RotateString {
//     static void rotate(String[] words, int start, int end) {
//     while (start < end) {
//         String temp = words[start];
//         words[start] = words[end];
//         words[end] = temp;
//         start++;
//         end--;
//     }
// }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string:"); // sameple input: "Hello World from Java"
        String s = sc.nextLine();
        System.out.println("Enter the number of rotations:");// sample k = 2
        int k = sc.nextInt();
        
       
        String[] words = s.split(" ");
         int n = words.length;
         k = k % n; // Handle cases where k is greater than n

         StringBuilder sb = new StringBuilder();
            for (int i = n - k; i < n; i++) {
                sb.append(words[i]).append(" ");
            }
            for (int i = 0; i < n - k; i++) {
                sb.append(words[i]).append(" ");
            }
        // rotate(words, 0, n - 1);
        // rotate(words, 0, k - 1);
        // rotate(words, k, n - 1);
        System.out.println("Rotated String:");

        // String result = String.join(" ", words);
        System.out.println(sb.toString().trim());
        sc.close();
        
    }
}
