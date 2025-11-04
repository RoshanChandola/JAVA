
public class Palindrome_number {

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int original = x;
        int reversed = 0;
        while (x != 0) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x /= 10;
        }
        return original == reversed;
    }
    public static void main(String[] args) {
        Palindrome_number pn = new Palindrome_number();
        System.out.println(pn.isPalindrome(121)); // true
        System.out.println(pn.isPalindrome(-121)); // false
        System.out.println(pn.isPalindrome(10)); // false
        System.out.println(pn.isPalindrome(12321)); // true
    }
}