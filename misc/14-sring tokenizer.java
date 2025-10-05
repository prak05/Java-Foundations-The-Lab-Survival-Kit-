import java.util.StringTokenizer;

public class StringTokenExample {
    public static void main(String[] args) {
        String str = "Java is fun to learn!";
        StringTokenizer st = new StringTokenizer(str, " ");

        System.out.println("Tokens:");

        while (st.hasMoreTokens()) {
            System.out.println(st.nextToken());
        }
    }
}

