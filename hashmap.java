import java.util.*;

public class hashmap {
    public static void main(String[] args) {
        HashMap<String,Integer>map = new HashMap<>();

        map.put("roshan",85);
        map.put("uday", 99);
        System.out.println(map.containsKey("roshan"));

        HashSet<Integer> set = new HashSet<>();
        set.add(5);
        set.add(7);

        System.out.println(set);

        TreeMap<String,Integer> treeMap = new TreeMap<>();
        treeMap.put("roshan",85);   
            treeMap.put("uday", 99);
        System.out.println("TreeMap: "+treeMap);
        
    }
}
// for (Map.Entry<String,Integer> e: map.entrySet())
//         {
//             System.out.println(e.getKey()+" "+e.getValue());
//         }
// Collections.max(map.values())
// for(entry: map.entrySet())
// if(entry.getValue()==Collections.max(map.values()))





