import java.util.Scanner;

public class CheckDigit {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a 4-digit code: ");
        String code = input.nextLine();
        int d1 = code.charAt(0) - '0';
        int d2 = code.charAt(1) - '0';
        int d3 = code.charAt(2) - '0';
        int d4 = code.charAt(3) - '0';
        
        int sum = (int) d1 + d2 + d3 + d4;
        System.out.println("Digit sum: " + sum);
        int checkDigit = sum % 10 ;
        System.out.println("Check digit: " + checkDigit);
        String fullCode = code + checkDigit ;
        System.out.println("Full code: " + fullCode);
        

        input.close();
    }
}