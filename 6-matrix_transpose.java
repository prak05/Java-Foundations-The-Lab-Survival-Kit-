import java.util.Scanner;

class MatrixTranspose {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of rows in the matrix: ");
        int r = sc.nextInt();
        System.out.print("Enter the number of columns in the matrix: ");
        int c = sc.nextInt();

        int[][] m = new int[r][c];
        int[][] trp = new int[c][r];

        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
            System.out.println("Enter elements at["+i+"]["+j+"] position:");
                m[i][j] = sc.nextInt();
            }
        }

        System.out.println("Matrix before transpose:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                trp[j][i] = m[i][j];
            }
        }

        System.out.println("Transpose of the matrix:");
        for (int i = 0; i < c; i++) {
            for (int j = 0; j < r; j++) {
                System.out.print(trp[i][j] + " ");
            }
            System.out.println();
        }
    }
}

