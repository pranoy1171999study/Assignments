public class Factorial {
    public static void main(String[] args) {
        System.out.print(factorial(6));
    }

    public static int factorial(int n) {
        int ans = 1;
        for (int i = 1; i <= n; i++)
            ans *= i;
        return ans;
    }

}
