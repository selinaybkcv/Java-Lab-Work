import java.util.Scanner;

public class Encoder {
   public static void main(String[] args) {
   Scanner inp = new Scanner(System.in);
   System.out.print("Enter a number to encode: ");
   int originalNumber = inp.nextInt();
   int encodedNumber = (originalNumber * 3 + 12);
   System.out.println("Encoded Number: " + encodedNumber);
   
   }
}