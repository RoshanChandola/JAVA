
 import java.util.Scanner;
 public class Alpabet_check {
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char ch = Character.toLowerCase(sc.next().charAt(0));

        if (Character.isLetter(ch))
            System.out.println(ch + " is an alphabet");
        else
            System.out.println(ch + " is not an alphabet");
    }
}


