import java.util.Random;
import java.util.Scanner;

public class SimplePinballGame {

    private static final int WIDTH = 40;
    private static final int HEIGHT = 15;
    private static final char BALL_SYMBOL = '*';
    private static final char PADDLE_SYMBOL = '-';
    private static final char WALL_SYMBOL = '#';
  private static final char NEWLINE = '\n';


    private static char[][] board = new char[HEIGHT][WIDTH];
    private static Random random = new Random();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeBoard();
        drawInitialState();

        while (true) {
            System.out.print("\nCurret state:\n");
            printBoard();
            
            String userAction = scanner.nextLine().trim();
            if (userAction.equalsIgnoreCase("exit")) {
                break;
            }

            executeUserAction(userAction);
        }

        scanner.close();
    }

    private static void initializeBoard() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                if (j == 0 || j == WIDTH - 1) {
                    board[i][j] = WALL_SYMBOL;
                } else {
                    board[i][j] = EMPTY_SPACE;
                }
            }
        }

        // Place ball at random position
        int ballX = random.nextInt(WIDTH);
        int ballY = random.nextInt(HEIGHT);
        board[ballY][ballX] = BALL_SYMBOL;

        // Create paddle at bottom center
        int paddleX = WIDTH / 2;
        int paddleY = HEIGHT - 1;
        board[paddleY][paddleX] = PADDLE_SYMBOL;
    }

    private static void drawInitialState() {
        System.out.println("Welcome to Simple Pinball!");
        System.out.println("Use arrow keys to move the paddle.");
        System.out.println("Press 'exit' to quit.");
    }

    private static void printBoard() {
        for (int i = 0; i < HEIGHT; i++) {
            for (int j = 0; j < WIDTH; j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    private static void executeUserAction(String action) {
        switch (action.toLowerCase()) {
            case "left":
                movePaddleLeft();
                break;
            case "right":
                movePaddleRight();
                break;
            default:
                System.out.println("Invalid input. Please try again.");
        }
    }

    private static void movePaddleLeft() {
        int paddleX = findPaddlePosition().x;
        if (paddleX > 1) {
            board[findPaddlePosition().y][paddleX] = EMPTY_SPACE;
            paddleX--;
            board[findPaddlePosition().y][paddleX] = PADDLE_SYMBOL;
        }
    }

    private static void movePaddleRight() {
        int paddleX = findPaddlePosition().x;
        if (paddleX < WIDTH - 2) {
            board[findPaddlePosition().y][paddleX] = EMPTY_SPACE;
            paddleX++;
            board[findPaddlePosition().y][paddleX] = PADDLE_SYMBOL;
        }
    }

    private static Position findPaddlePosition() {
        for (int y = 0; y < HEIGHT; y++) {
            for (int x = 0; x < WIDTH; x++) {
                if (board[y][x] == PADDLE_SYMBOL) {
                    return new Position(x, y);
                }
            }
        }
        throw new RuntimeException("Paddle not found on the board");
    }

    private static class Position {
        final int x;
        final int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

