import java.util.Scanner;

public class StepCounter {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter daily steps (0 to finish): ");
        int steps = input.nextInt();
        int totalSteps = 0;
        int days = 0;
        
        
        while (steps != 0){
        
            days++ ;
            totalSteps += steps;
            System.out.print("Enter daily steps (0 to finish): ");
            steps = input.nextInt();
        }
        
        System.out.print("Total Steps: " + totalSteps);
        System.out.print("\n" + "Days: " + days);

        input.close();
    }
}