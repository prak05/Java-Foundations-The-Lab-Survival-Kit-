import java.util.Scanner;

class Prime {
    public static void main(String args[]) {
        int no, flag = 1;
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the number:");
        no = sc.nextInt();

        if (no <= 1) {
            System.out.println(no + " is not a prime number.");
            return;
        }

        for (int i = 2; i <= no / 2; i++) {
            if (no % i == 0) {
                flag = 0;
                break;
            }
        }
        
        if (flag == 1) {
            System.out.println(no + " is a prime number.");
        } else {
            System.out.println(no + " is not a prime number.");
        }
    }
}

