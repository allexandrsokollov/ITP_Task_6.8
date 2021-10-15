package vsu.csf.sokolov_aa;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
	    int n = getIntFromConsole("enter N");
        double x = getDoubleFromConsole("Enter X");

        System.out.println(findSumOfElem(n, x));
    }

    public static double findSumOfElem(int n, double x) {
        double sum = 1;
        double prev = 1;

        for(int i = 1; i <= n; i++) {

            if(isOdd(i)) {
                prev *= (i * x) / (2 * i);
            } else {
                prev *=  (-x) / (2 * i);
            }
            sum += prev;
        }

        return sum;
    }


    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }

    public static int getIntFromConsole(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print("\n" + message + ": ");
        return in.nextInt();
    }


    public static double getDoubleFromConsole(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print("\n" + message + ": ");
        return in.nextDouble();
    }

}
