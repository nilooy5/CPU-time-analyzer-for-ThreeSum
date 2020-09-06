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
        // int n = Integer.parseInt("10000000");
        Scanner scanner = new Scanner(new File("src/4K_ints.txt"));
        int [] tall = new int [4000];
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


        // sum of square roots of integers from 1 to n using Math.sqrt(x).
        /*StopwatchCPU timer1 = new StopwatchCPU();
        double sum1 = 0.0;
        *//*for (int i = 1; i <= n; i++) {
            sum1 += Math.sqrt(i);
        }
        double time1 = timer1.elapsedTime();
        StdOut.printf("%e (%.2f seconds)\n", sum1, time1);*//*

        // sum of square roots of integers from 1 to n using Math.pow(x, 0.5).
        StopwatchCPU timer2 = new StopwatchCPU();
        double sum2 = 0.0;
        for (int i = 1; i <= n; i++) {
            sum2 += Math.pow(i, 0.5);
        }
        double time2 = timer2.elapsedTime();
        StdOut.printf("%e (%.2f seconds)\n", sum2, time2);*/
    }
}
