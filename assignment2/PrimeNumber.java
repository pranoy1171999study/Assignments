package assignments;

import java.util.Scanner;

public class PrimeNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n ");
        int n = sc.nextInt();
        System.out.print("Prime Status : " + isPrime(n));
    }

    public static boolean isPrime(int n) {
        if (n < 2)
            return false;
        for (int i = 2; i < n; i++) {
            if (n % 2 == 0)
                return false;
        }
        return true;
    }
}
