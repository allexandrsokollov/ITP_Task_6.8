package vsu.csf.sokolov_aa;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Locale.setDefault(Locale.ROOT);
	int n = getIntFromConsole("enter N");
        double x = getDoubleFromConsole("\nEnter X");
        double eps = getDoubleFromConsole("\nEnter eps");

        System.out.println("\nSum of elements is " + findSumOfElem(n, x));
        System.out.println("Sum of elements that bigger then eps is " + findSumOfElemThatBiggerThanEps(eps, x));
        System.out.println("Sum of elements that bigger then eps / 10 is " + findSumOfElemThatBiggerThanEps(eps / 10, x));
        System.out.println("Value via Math library is " + Math.sqrt(1 + x));
    }

    public static double findSumOfElem(int n, double x) {
	    
	if(n == 0){
		return 0;
	}
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

    public static double findSumOfElemThatBiggerThanEps(double eps, double x) {
        double sum = 1;
        double prev = 1;

        for(int i = 1; prev > eps; i++) {

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
        System.out.print(message + ": ");
        return in.nextInt();
    }


    public static double getDoubleFromConsole(String message) {
        Scanner in = new Scanner(System.in);
        System.out.print(message + ": ");
        return in.nextDouble();
    }

}
