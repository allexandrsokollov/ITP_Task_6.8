package vsu.csf.sokolov_aa;

import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static double[] findSumOfElem(int n, double x, double eps) {
        final double[]  sum = new double[3];
        double prev = 1;

        for (int i = 1; (Math.abs(prev) >= eps / 10) || i <= n; i++) {

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

    public static double[] dmitriIvanovichVersion(int n, double x, double eps) {
        final double[]  sum = new double[3];
        double prev = 1;

        for (int i = 1; (Math.abs(prev) >= eps / 10) || i <= n; i++) {

            if (Math.abs(prev) >= eps) {
                sum[0] += prev;
            }

            if (Math.abs(prev) >= eps / 10) {
                sum[1] += prev;
            }

            if (i <= n) {
                sum[2] += prev;
            }


            prev = (-1) * prev * ((2 * i -3 ) * x / (2 * i - 1));

        }

        return sum;
    }


    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);

	    int n = getIntFromConsole("enter N");
        double x = getDoubleFromConsole("\nEnter X");
        double eps = getDoubleFromConsole("\nEnter eps");

        double[] result = findSumOfElem(n, x, eps);

        double[] dMResult = dmitriIvanovichVersion(n, x, eps);

        System.out.printf("\nSum of elements is %.010f", result[2]);
        System.out.printf("\nSum of elements that bigger then eps is %.010f", result[0]);
        System.out.printf("\nSum of elements that bigger then eps / 10 is %.010f", result[1]);
        System.out.printf("\nValue via Math library is %.010f", Math.sqrt(1 + x));

        System.out.printf("\n\n\nSum of elements is %.010f", dMResult[2]);
        System.out.printf("\nSum of elements that bigger then eps is %.010f", dMResult[0]);
        System.out.printf("\nSum of elements that bigger then eps / 10 is %.010f", dMResult[1]);
        System.out.printf("\nValue via Math library is %.010f", Math.sqrt(1 + x));
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
