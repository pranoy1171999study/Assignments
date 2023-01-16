package assignments;

// Pass integer values of an array from Command Line argument
// Convert the numbers to int and find the statistics
// 1. sum 
// 2. average
// 3. min
// 4. max
// 5. median
// 6. frequency of each number in the array
public class CommandLineStatistics {
    public static void main(String args[]) {
        int argLn = args.length;
        int arr[] = new int[argLn];
        int sum = 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        // converting the strings value from command lines to int values
        for (int i = 0; i < argLn; i++) {
            arr[i] = Integer.parseInt(args[i]);
            sum += arr[i];
            if (arr[i] < min)
                min = arr[i];
            if (arr[i] > max)
                max = arr[i];
        }
        // sorting(Bubble sort) for median and frequency
        for (int i = 0; i < argLn; i++) {
            for (int j = i + 1; j < argLn; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        System.out.println("Sum of the elements : " + sum);
        System.out.println("Average of the elements : " + (sum / (float) argLn));
        System.out.println("Min of the elements : " + min);
        System.out.println("Max of the elements : " + max);
        // for median
        if (argLn % 2 == 0)
            System.out.println("Median of the elements : " + (arr[argLn / 2] + (float) arr[(argLn / 2) - 1]) / 2
                    + "\n(Here we take avarage of " + arr[argLn / 2] + " and " + arr[(argLn / 2) - 1]
                    + " as both are middle element) \n\n");
        else
            System.out.println("Median of the elements : " + arr[argLn / 2] + "\n\n");
        System.out.println("Frequencies of the elements : ");

        // for frequency in sorted array
        int c = 0;
        for (int i = 1; i < argLn; i++) {
            if (arr[i] != arr[i - 1]) {
                System.out.println(arr[i - 1] + " : " + (c + 1));
                c = 0;
            } else {
                c++;
            }
        }
        System.out.println(arr[argLn - 1] + " : " + (c + 1));

    }
}
