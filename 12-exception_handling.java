import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

class DivisionProgram {
    private int a;
    private int b;


    public DivisionProgram() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        System.out.print("Enter Number-1: ");
        this.a = Integer.parseInt(reader.readLine());
        
        System.out.print("Enter Number-2: ");
        this.b = Integer.parseInt(reader.readLine());
        
        if (b == 0) {
            throw new Exception("Division by zero is not allowed.");
        }
        
        reader.close();
    }

    public void performDivision() {
        int result = a / b;
        System.out.println("Result = " + result);
    }

    public static void main(String[] args) {
        try {
            DivisionProgram divisionProgram = new DivisionProgram();
            divisionProgram.performDivision();
        } 
        catch (IOException e) {
            System.out.println("Error reading input: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

