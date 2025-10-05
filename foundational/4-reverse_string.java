import java.util.Scanner;

class Reverse {
    public static void main(String args[]) {
        
        Scanner sc = new Scanner(System.in);
        int i, l;
        System.out.println("Enter the string: ");
        String ch = sc.nextLine();
        l = ch.length();
        System.out.println("The reversed string is:");
        for(i = l - 1; i >= 0; i--) {
            System.out.print(ch.charAt(i));
        }
    }
}

