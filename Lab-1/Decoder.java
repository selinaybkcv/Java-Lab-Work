import java.util.Scanner;

public class Decoder {
   public static void main(String[] args) {
   Scanner inp = new Scanner(System.in);
   System.out.print("Enter a number to decode: ");
   int encodedNumber = inp.nextInt();
   int originalNumber = ((encodedNumber - 12) / 3);
   System.out.println("Decoded Number: " + originalNumber);
   
   }
}