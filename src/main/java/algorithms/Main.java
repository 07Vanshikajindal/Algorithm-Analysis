package algorithms;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements in the array:");
        int n = sc.nextInt();

        int[] nums = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Call the Boyer-Moore algorithm
        int result = BoyerMoore.findMajority(nums);

        // Display result
        if (result != -1) {
            System.out.println(" Majority element is: " + result);
        } else {
            System.out.println(" No majority element found.");
        }

        sc.close();
    }
}
