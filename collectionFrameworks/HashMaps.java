import java.util.*;
class HashMaps{
    public static void main(String[] args) {
 
    HashMap<Integer, String> map = new HashMap<>();
    map.put(1,"roshan");
    }
} 
// HashMap is a part of Java's collection framework and is used to store data in key-value pairs. It allows for efficient data retrieval based on keys.
// In a HashMap, keys are unique, and each key maps to a single value.  
// HashMaps are implemented using a hash table, which provides average-case constant time complexity (O(1)) for basic operations like insertion, deletion, and lookup.
// Example usage of HashMap:

// Creating a HashMap
// HashMap<Integer, String> map = new HashMap<>();
// Adding key-value pairs
// map.put(1, "One");
// map.put(2, "Two");
// Retrieving a value by key    
// String value = map.get(1); // returns "One"
// Removing a key-value pair
// map.remove(2);
// Checking if a key exists
// boolean exists = map.containsKey(1); // returns true
// Iterating through the HashMap

// for (Map.Entry<Integer, String> entry : map.entrySet()) {
//     System.out.println("Key: " + entry.getKey() + ", Value: " + entry.getValue());
// }
// HashMaps are widely used in scenarios where fast data retrieval is required, such as caching, indexing, and implementing associative arrays.

