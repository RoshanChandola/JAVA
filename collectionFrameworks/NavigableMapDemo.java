import java.util.NavigableMap;
import java.util.TreeMap;
// Navigable Map extends the Sorted Map
// And it implements the Tree Map
public class NavigableMapDemo {
    public static void main(String[] args) {
        NavigableMap<Integer,String> nav=new TreeMap<>();
        nav.put(1,"One");
        nav.put(5,"Five");
        nav.put(3,"Three");

        System.out.println(nav);
        System.out.println(nav.lowerEntry(4));// it will return the lower entry of the given key
        System.out.println(nav.ceilingEntry(3));//it will return the ceiling entry of the given key
        System.out.println(nav.higherEntry(1));// it will return the higher entry of the given key 
        System.out.println(nav.floorEntry(2));//it will return the floor entry of the given key
    }
}
