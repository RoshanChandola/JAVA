import java.util.*;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;
public class HashMapTry {
    public static void main(String[] args) {
        // Your code here
        HashMap<String,Integer>map = new LinkedHashMap<>();
        map.put("roshan",1);
        map.put("uday",2);
        map.put("vedaant",3);
        map.put("amit",4);
        map.put("roht",5);
        for(Map.Entry<String,Integer> entry:map.entrySet())
        {
            System.out.println(entry.getKey()+" "+entry.getValue());
        }
         int a = Collections.max(map.values());
         System.out.println(a);

         System.out.println(map.get("roshan"));
        int max = Collections.max(map.values());
         for(String key:map.keySet())
         {
            if(max == map.get(key))
             System.out.println(key);
         }
    }
}
