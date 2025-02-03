package Solution;

import java.util.Scanner;

public class BubbleSort
{
    public static void main(String[] args)
    {
        try
        (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Enter the number of elements:");
            int n = scanner.nextInt();
            int[] arr = new int[n];
            
            System.out.println("Enter the elements:");
            for (int i = 0; i < n; i++)
            {
                arr[i] = scanner.nextInt();
            }
            
            char order;
            while (true)
            {
                System.out.println("Sort in ascending or descending order? (A/D):");
                order = scanner.next().toLowerCase().charAt(0);
                if (order == 'a' || order == 'd')
                {
                    break;
                }
                else
                {
                    System.out.println("Invalid input. Please enter 'A' or 'D'.");
                }
            }
            
            int steps = bubbleSort(arr, order);
            
            System.out.println("Sorted array:");
            for (int num : arr)
            {
                System.out.print(num + " ");
            }
            System.out.println("\nSteps taken: " + steps);
        }
        catch (Exception e)
        {
            System.out.println("Invalid input. Please enter valid numbers.");
        }
    }
    
    public static int bubbleSort(int[] arr, char order)
    {
        int n = arr.length;
        int steps = 0;
        boolean swapped;
        
        for (int i = 0; i < n - 1; i++)
        {
            swapped = false;
            for (int j = 0; j < n - 1 - i; j++)
            {
                if ((order == 'a' && arr[j] > arr[j + 1]) || (order == 'd' && arr[j] < arr[j + 1]))
                {
                    arr[j] = arr[j] + arr[j + 1];
                    arr[j + 1] = arr[j] - arr[j + 1];
                    arr[j] = arr[j] - arr[j + 1];
                    swapped = true;
                }
                steps++;
            }
            if (!swapped)
            {
                break;
            }
        }
        return steps;
    }
}
