import java.util.Scanner;

public class ParkingFee{
   public static void main(String[] args){
   Scanner input= new Scanner(System.in);
   System.out.print("Enter a vehicle type: ");
   int vehicleType = input.nextInt();
   
   int billedHours;
   int hourRate;
   int fee;
   
   System.out.print("Enter the park time in minutes: ");
   int minutes= input.nextInt();
   
   if (minutes % 60 == 0){
      billedHours= minutes/60; }
   else {
      billedHours= minutes/60 + 1; }
      
   if (vehicleType == 1){
      System.out.println("Motorcycle");
      hourRate= 10;
      if (billedHours <= 3){
         fee= hourRate * billedHours; }
      else if (4 <= billedHours && billedHours <= 8){
         fee= hourRate*3 * billedHours + hourRate/2 ; }
      else {
         fee= hourRate * 6; }
      System.out.println("Fee: " + fee);
   }
   else if (vehicleType == 2){
      System.out.println("Car");
      hourRate= 20;
      if (billedHours <= 3){
         fee= hourRate * billedHours; }
      else if (4 <= billedHours && billedHours <= 8){
         fee= hourRate*3 * billedHours + hourRate/2 ; }
      else {
         fee= hourRate * 6; }
      System.out.println("Fee: " + fee);
   } 
   else if (vehicleType == 3){
      System.out.println("Minibus");
      hourRate= 30;
      if (billedHours <= 3){
         fee= hourRate * billedHours; }
      else if (4 <= billedHours && billedHours <= 8){
         fee= hourRate*3 * billedHours + hourRate/2 ; }
      else {
         fee= hourRate * 6; }
      System.out.println("Fee: " + fee);
   }
   else {
      System.out.println("Invalid vehicle.");
   }     
         
     input.close();    
   }
}