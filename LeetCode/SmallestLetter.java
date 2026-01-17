public class SmallestLetter {
    public char nextGreatestLetter(char[] letters, char target) {
        int start = 0;
        int end = letters.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (letters[mid] <= target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return letters[start % letters.length];
    }
    public static void main(String[] args) {
        SmallestLetter sl = new SmallestLetter();
        char[] letters = {'c', 'f', 'j'};
        char target = 'c';
        System.out.println(sl.nextGreatestLetter(letters, target)); // Output: 'c'
    }
}
