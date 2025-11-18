import java.util.*;

class compareStrings implements Comparator<String>{
    @Override
    public int compare(String s1,String s2){
        return s1.length()-s2.length();
    }
}
class Comparotors{
    public static void main(String[] args){
        List<String> names=Arrays.asList("apple","roshan","banana","mango");
        names.sort(new compareStrings());
        System.out.println(names);
    }
}