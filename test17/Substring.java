package assignments.test17;

import java.util.HashMap;
import java.util.Scanner;

public class Substring {
    final static int hashCode = 5;

    public static int hashvalue(char del, char add, int n, int p) {
        n = (((n - (del - 64)) / hashCode) + ((add - 64) * (int) Math.pow(hashCode, p - 1)));
        return n;
    }

    public static boolean substr(String text, String part) {
        int t = text.length();
        int p = part.length();
        if (t < p)
            return false;
        int pHash = 0;
        int tHash = 0;
        for (int i = 0; i < p; i++) {
            pHash += (((part.charAt(i) - 64) * Math.pow(hashCode, i)));
            tHash += (((text.charAt(i) - 64) * Math.pow(hashCode, i)));
        }
        if (tHash == pHash) {
            if (part.equals(text.substring(0, p))) {
                return true;
            }
        }
        for (int i = p; i < t; i++) {
            tHash = hashvalue(text.charAt(i - p), text.charAt(i), tHash, p);
            if (tHash == pHash) {
                if (part.equals(text.substring(i - p + 1, i + 1))) {
                    return true;
                }
            }

        }
        return false;
    }

    public static void main(String[] args) {
        String text, part;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter text : ");
        text = sc.nextLine();
        System.out.print("Enter part : ");
        part = sc.nextLine();
        System.out.println(substr(text, part));
    }
}
