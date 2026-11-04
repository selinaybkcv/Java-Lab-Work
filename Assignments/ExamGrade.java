import java.util.Scanner;

public class ExamGrade{
   public static void main(String[] args){
      Scanner inp = new Scanner(System.in);
      System.out.print("Enter the midterm score: ");
      int midtermScore = inp.nextInt();
      System.out.print("Enter the final score: ");
      int finalScore = inp.nextInt();
      
      if(0<= midtermScore && midtermScore <=100 && 0<= finalScore && finalScore <= 100){
         double average = 0.4 * midtermScore + 0.6 * finalScore ;
         System.out.println("Average: " + average);
      
      if(finalScore <50)
         System.out.print("Letter grade: FF");
      else if(average >= 90)
         System.out.print("Letter grade: AA");
      else if(average >= 85)
         System.out.print("Letter grade: BA");
      else if(average >= 80)
         System.out.print("Letter grade: BB");
      else if(average >= 75)
         System.out.print("Letter grade: CB");
      else if(average >= 70)
         System.out.print("Letter grade: CC");
      else if(average >= 65)
         System.out.print("Letter grade: DC");
      else if(average >= 60)
         System.out.print("Letter grade: DD");
      else if(average >= 50)
         System.out.print("Letter grade: FD");
      else
         System.out.print("Letter grade: FF");
      }
      else{
         System.out.print("Invalid score.");
      }
     

   }
}