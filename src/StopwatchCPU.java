import java.io.File;
import java.io.FileNotFoundException;
import java.lang.management.ManagementFactory;
import java.lang.management.ThreadMXBean;
import java.util.Scanner;

public class StopwatchCPU {
    private static final double NANOSECONDS_PER_SECOND = 1000000000;

    private final ThreadMXBean threadTimer;
    private final long start;

    /**
     * Initializes a new stopwatch.
     */
    public StopwatchCPU() {
        threadTimer = ManagementFactory.getThreadMXBean();
        start = threadTimer.getCurrentThreadCpuTime();
    }

    /**
     * Returns the elapsed CPU time (in seconds) since the stopwatch was created.
     *
     * @return elapsed CPU time (in seconds) since the stopwatch was created
     */
    public double elapsedTime() {
        long now = threadTimer.getCurrentThreadCpuTime();
        return (now - start) / NANOSECONDS_PER_SECOND;
    }

    public static int count(int[] a)
    { // Count triples that sum to 0.
        int N = a.length;
        int cnt = 0;
        for (int i = 0; i < N; i++)
            for (int j = i+1; j < N; j++)
                for (int k = j+1; k < N; k++)
                    if (a[i] + a[j] + a[k] == 0)
                        cnt++;
        return cnt;
    }

    /**
     * Unit tests the {@code StopwatchCPU} data type.
     * Takes a command-line argument {@code n} and computes the
     * sum of the square roots of the first {@code n} positive integers,
     * first using {@code Math.sqrt()}, then using {@code Math.pow()}.
     * It prints to standard output the sum and the amount of time to
     * compute the sum. Note that the discrete sum can be approximated by
     * an integral - the sum should be approximately 2/3 * (n^(3/2) - 1).
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        Scanner scanner = new Scanner(new File("src/1K_ints.txt"));
        int [] tall = new int [1000];
        int index = 0;
        while(scanner.hasNextInt())
        {
            tall[index++] = scanner.nextInt();
        }

        for (int i : tall) {
            System.out.println(i);
        }

        StopwatchCPU timer = new StopwatchCPU();
        StdOut.println();
        StdOut.println("Class Assignment 2 by Munira Tabassum ");

        StdOut.println("Total ThreeSums: " + count(tall));
        StdOut.println("Analyzing finished");

        double time = timer.elapsedTime();
        StdOut.printf(" (%.2f seconds)\n", time);
    }
}
