import java.util.Scanner;

public class Elevator {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.print("Enter the current floor: ");
        int start = input.nextInt();
        if (start < 0){
            System.out.println("Invalid input.");
            input.close();
            return;
        }
        
        System.out.print("Enter the direction (1 = up, -1 = down): ");
        int direction = input.nextInt();
        if (direction != 1 && direction != -1){
            System.out.println("Invalid input.");
            input.close();
            return;
        }
        
        System.out.print("Enter the number of requests: ");
        int n = input.nextInt();
        if (n < 1){
            System.out.println("Invalid input.");
            input.close();
            return;
        }
        
        System.out.print("Enter the requested floors: ");
        int[] requests = new int[n];
        for (int i = 0; i < n; i++){
            requests[i] = input.nextInt();
            if (requests[i] < 0){
                System.out.println("Invalid input.");
                input.close();
                return;
            } 
                        
        }
                    
        int[] stops = serviceOrder(requests, start, direction);
        System.out.print("Stops:");
        for (int i = 0; i < stops.length; i++) {
            System.out.print(" " + stops[i]);
        }
        System.out.println();  
                        
        int distance = totalDistance(start, stops);
        System.out.println("Total distance: " + distance);
                        
        int[] numbers = stopNumbers(requests, stops);
        System.out.print("Stop numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(" " + numbers[i]);
        }                       
        System.out.println();
        
        input.close();
    }

    // Returns the pending floor nearest to current in the given direction, or -1 if there is none.
    public static int nextStop(int[] requests, boolean[] served, int current, int direction) {
        int result = -1;
        for (int i = 0; i < requests.length; i++){
            if (!served[i]){
               if (direction == 1 && requests[i] > current){
                  if (result == -1 || requests[i] < result) {
                        result = requests[i];
                  }
               } 
               else if (direction == -1 && requests[i] < current) {
                    if (result == -1 || requests[i] > result) {
                        result = requests[i];
                    }
               }
            } 
        }
        
        return result;
    }

    // Returns the floors where the elevator stops, in the order it stops there.
    public static int[] serviceOrder(int[] requests, int start, int direction) {
        int n = requests.length;
        if (n == 0)
            return new int[0];
            
        boolean[] served = new boolean[n];
        int[] tempStops = new int[n];
        int stopCount = 0;
        int servedCount = 0;
        int current = start;
        int currentDir = direction;
        boolean startRequested = false;
        
        for (int i = 0; i < n; i++) {
            if (requests[i] == start) {
                served[i] = true;
                servedCount++;
                startRequested = true;
            }
        }
        
        if (startRequested) {
            tempStops[stopCount++] = start;
        }
        
        while (servedCount < n) {
            int next = nextStop(requests, served, current, currentDir);
            if (next == -1) {
                currentDir = -currentDir;
                next = nextStop(requests, served, current, currentDir);
            }

            current = next;
            tempStops[stopCount++] = current;
            
            for (int i = 0; i < n; i++) {
                if (!served[i] && requests[i] == current) {
                    served[i] = true;
                    servedCount++;
                }
            }
        }
        
        int[] result = new int[stopCount];
        for (int i = 0; i < stopCount; i++) {
            result[i] = tempStops[i];
        }     
            
        return result;
    }

    // Returns the total number of floors travelled from start through all the stops.
    public static int totalDistance(int start, int[] stops) {
        if (stops.length == 0) {
            return 0;
        }

        int total = 0;
        int current = start;

        for (int i = 0; i < stops.length; i++) {
            total += Math.abs(stops[i] - current);
            current = stops[i];
        }
        
        return total;
    }

    // For each request, returns the number of the stop that served it (the first stop is 1).
    public static int[] stopNumbers(int[] requests, int[] stops) {
        int[] numbers = new int[requests.length];

        for (int i = 0; i < requests.length; i++) {
            for (int j = 0; j < stops.length; j++) {
                if (requests[i] == stops[j]) {
                    numbers[i] = j + 1; 
                    break;
                }
            }
        }
        return numbers;
    }
}
