import java.util.*;

public class FindMostFreqStr {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string:"); // Fixed missing quotes
        String str = sc.nextLine();
        
        if (str == null || str.trim().isEmpty()) {
            System.out.println("Input is empty.");
            return;
        }

        // Fixed regex from //s+ to "\\s+"
        String[] words = str.toLowerCase().split("\\s+"); 

        HashMap<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // int maxfreq = Collections.max(freqMap.values());
        //or 
        int maxfreq = 0;
        for (int freq : freqMap.values()) {
            if (freq > maxfreq) {
                maxfreq = freq;
            }
        }

        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            if (entry.getValue() == maxfreq) {
                System.out.println("Most frequent: " + entry.getKey());
            }
        }
        sc.close(); // Recommended practice to close the scanner
    }
}
