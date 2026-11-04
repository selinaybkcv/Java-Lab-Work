import java.util.Scanner;

public class Blackhole {
   public static void main(String[] args) {
      Scanner input = new Scanner(System.in);
      System.out.print("Enter a 3-digit number: ");
      int number = input.nextInt();

      if (number < 100 || number > 999) {
         System.out.println("Invalid number.");
      }
      else if (number % 111 == 0) {
         System.out.println("Invalid number: all digits are the same.");
      }
      else {
         int count = 0;
         while (number != 495) {
            count++;

            int d1 = number % 10;
            int d2 = (number / 10) % 10;
            int d3 = number / 100;

            int big = 0;
            int small = 0;
            String bigText = "";
            String smallText = "";
            
            for (int digit = 9; digit >= 0; digit--) {
               if (d1 == digit){ 
                  big = big * 10 + digit; 
                  bigText = bigText + digit; }
               if (d2 == digit){ 
                  big = big * 10 + digit; 
                  bigText = bigText + digit; }
               if (d3 == digit){ 
                  big = big * 10 + digit; 
                  bigText = bigText + digit; }
            }
            for (int digit = 0; digit <= 9; digit++) {
               if (d1 == digit){ 
                  small = small * 10 + digit; 
                  smallText = smallText + digit; }
               if (d2 == digit){ 
                  small = small * 10 + digit; 
                  smallText = smallText + digit; }
               if (d3 == digit){ 
                  small = small * 10 + digit; 
                  smallText = smallText + digit; }
            }           
            System.out.println("Big_" + count + " : " + bigText);
            System.out.println("Small_" + count + " : " + smallText);
            number = big - small;
         }
         System.out.println("Number: " + number);
         System.out.println("Count: " + count);
      }
      input.close();
   }
}
