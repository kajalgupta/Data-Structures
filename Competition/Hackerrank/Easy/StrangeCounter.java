import java.util.Scanner;

public class StrangeCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Long n = scanner.nextLong();
        System.out.println(count(n));
        scanner.close();

    }

    private static long count(Long n) {
        long cycleStart = 1;
        long cycleStartValue = 3;
        if (cycleStart==n) {
            return cycleStartValue;
        }
        long lastKey = 0;
        long lastValue = 0; 
        while (cycleStart<n) {
            lastKey = cycleStart;
            lastValue = cycleStartValue;
            cycleStart = cycleStart + cycleStartValue;
            cycleStartValue = cycleStartValue*2;
            if (cycleStart==n) {
                return cycleStartValue;
            }
        }
        long x = n-lastKey;
        return lastValue-x;
    }
    
}