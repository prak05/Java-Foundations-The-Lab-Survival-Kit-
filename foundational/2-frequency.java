import java.util.Scanner;

class Freq {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter the string:");
        String s = sc.nextLine();
        
        System.out.println("Enter the character to be searched:");
        char ch = sc.nextLine().charAt(0);
        
        int count = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                count++;
            }
        }
        
        System.out.println("Count of the frequency of '" + ch + "' = " + count);
    }
}







