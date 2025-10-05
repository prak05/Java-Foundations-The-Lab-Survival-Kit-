import java.util.Scanner;

class Small {
    public static void main(String args[]) {
        int n, i, j;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the limit of the array:");
        n = sc.nextInt();
        int a[] = new int[n];
        
        System.out.println("Enter the elements in the array:");
        for (i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        
        for (i = 0; i < n - 1; i++) {
            for (j = 0; j < n - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    int swap = a[j];
                    a[j] = a[j + 1];
                    a[j + 1] = swap;
                }
            }
        }
        
        System.out.println("The sorted array is:");
        for (i = 0; i < n; i++) {
            System.out.println(a[i]);
        }
        
        if (n > 1) {
            System.out.println("2nd smallest number is: " + a[1]);
        } else {
            System.out.println("Array is too small to find the 2nd smallest number.");
        }
    }
}

