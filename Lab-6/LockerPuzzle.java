import java.util.Scanner;

public class LockerPuzzle {

    // main is given. Fill in only the blanks (______) with the names of your methods.
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the first locker number: ");
        int first = input.nextInt();
        System.out.print("Enter the last locker number: ");
        int last = input.nextInt();

        if (first < 1 || last < first || last > 10000) {
            System.out.println("Invalid range.");
        } else {
            int total = printOpenLockers(first, last);
            System.out.println("Open lockers in total: " + total);
            System.out.println("Locker " + last + " was toggled " + countDivisors(last) + " times.");
        }
        input.close();
    }

    // Method 1: number of positive integers that divide n exactly.
    public static int countDivisors(int n) {
        int result = 0;
        for(int i = 1 ; i <= n ; i++){
            if (n % i == 0)
                result++;
        }
        return result;
    }

    // Method 2: true if locker n is open at the end, false if it is closed.
    public static boolean isOpen(int n) {
        boolean result;
        if (countDivisors(n) % 2 == 0)
            result = false;
        else
            result = true;
        return result;
    }

    // Method 3: prints the line "Open lockers: ..." and returns how many lockers are open.
    public static int printOpenLockers(int first, int last) {
        int result= 0;
        String openLockers = " ";
        for( ; first <= last; first++){
            if (isOpen(first)){
                openLockers += first + " ";
                result++;
            }
        }
        if (openLockers == " ")
            openLockers = " none";
            
        System.out.print("Open lockers:" + openLockers + "\n");
        return result;
    }
}
