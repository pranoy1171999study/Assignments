package assignments.test17;

import java.util.Scanner;

public class LongestSequenceCharacter {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements (0 or 1 only)");
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int max = 0;
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] == 1) {
                c++;
            } else {
                if (max < c)
                    max = c;
                c = 0;
            }
        }
        if (max < c)
            max = c;// to handle the case of last sequence
        System.out.println("Longest sequence(of 1) is of length : " + max);

    }
}
