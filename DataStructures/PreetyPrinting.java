public class PreetyPrinting {
    public static void main(String[] args) {
        float a= 10.1234567f;
        System.out.printf("The value of a is %.2f",a);// printf is used to print the formatted string. %.2f is used to print the float value with 2 decimal places. if we want to print the float value with 3 decimal places then we can use %.3f and so on.
        

    //   there are multiple format specifiers that we can use with printf method. some of the commonly used format specifiers are:
    //   %d - for integer  
    //     %f - for float
    //     %s - for string
    //     %c - for character
    //     %b - for boolean
    //     %n - for new line
        System.out.printf("The value of a is %.3f",a);
    }
}
