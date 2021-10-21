package vsu.csf.sokolov_aa;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
	    int n = getIntFromConsole("enter N");
        double x = getDoubleFromConsole("\nEnter X");
        double eps = getDoubleFromConsole("\nEnter eps");

        double[] result = findSumOfElem(n, x, eps);

        System.out.println("\nSum of elements is " + result[2]);
        System.out.println("Sum of elements that bigger then eps is " + result[0]);
        System.out.println("Sum of elements that bigger then eps / 10 is " + result[1]);
        System.out.println("Value via Math library is " + Math.sqrt(1 + x));
    }

    public static double[] findSumOfElem(int n, double x, double eps) {
        final double[]  sum = new double[3];
        double prev = 1;

        for (int i = 1; Math.abs(prev) >= eps /10 || i <= n; i++) {

            if (Math.abs(prev) >= eps) {
                sum[0] += prev;
            }

            if (Math.abs(prev) >= eps / 10) {
                sum[1] += prev;
            }

            if (i <= n) {
                sum[2] += prev;
            }

            if (isOdd(i)) {
                prev *= (i * x) / (2 * i);
            } else {
                prev *=  (-x) / (2 * i);
            }
        }

        return sum;
    }




    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }

    public static int getIntFromConsole(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message + ": ");
        return in.nextInt();
    }


    public static double getDoubleFromConsole(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message + ": ");
        return in.nextDouble();
    }

}
