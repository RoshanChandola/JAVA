import java.util.HashSet;

public class HashSets {
    public static void main(String[] args) {
       HashSet<String> set = new HashSet<>();
         set.add("Roshan");
            set.add("Chandola");
        System.out.println(set.add("pro"));// it will return false because roshan is already present in the set
        System.out.println(set);
}
}
