import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
class PinballGame extends JPanel implements ActionListener, KeyListener {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int BALL_SIZE = 20;
    private static final int PADDLE_WIDTH = 120;
    private static final int PADDLE_HEIGHT = 15;
    private static final int FPS = 60;

    private int ballX, ballY, ballVelX, ballVelY;
    private int paddleX, paddleY;
    private Timer timer;
    private Random rand;

    public PinballGame() {
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        setBackground(Color.BLACK);

        rand = new Random();
        initializeGame();
        timer = new Timer(1000 / FPS, this);
        timer.start();

        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
    }

    private void initializeGame() {
        ballX = WIDTH / 2;
        ballY = HEIGHT / 2;
        ballVelX = rand.nextInt(4) + 2;
        ballVelY = rand.nextInt(4) + 2;

        paddleX = WIDTH / 2 - PADDLE_WIDTH / 2;
        paddleY = HEIGHT - 50;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw Ball
        g.setColor(Color.YELLOW);
        g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);

        // Draw Paddle
        g.setColor(Color.BLUE);
        g.fillRect(paddleX, paddleY, PADDLE_WIDTH, PADDLE_HEIGHT);
    }

    private void updateGame() {
        // Update ball position
        ballX += ballVelX;
        ballY += ballVelY;

        // Ball bouncing off walls
        if (ballX <= 0 || ballX >= WIDTH - BALL_SIZE) {
            ballVelX = -ballVelX;
        }
        if (ballY <= 0) {
            ballVelY = -ballVelY;
        }

        // Ball and paddle collision detection
        if (ballY + BALL_SIZE >= paddleY &&
                ballX + BALL_SIZE >= paddleX &&
                ballX <= paddleX + PADDLE_WIDTH) {
            ballVelY = -ballVelY;
        }

        // Ball falling below paddle (reset game)
        if (ballY >= HEIGHT) {
            initializeGame();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        updateGame();
        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        // Move paddle left
        if (key == KeyEvent.VK_LEFT && paddleX > 0) {
            paddleX -= 30;
        }

        // Move paddle right
        if (key == KeyEvent.VK_RIGHT && paddleX < WIDTH - PADDLE_WIDTH) {
            paddleX += 30;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not needed for this implementation
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Not needed for this implementation
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Pinball Game");
        PinballGame game = new PinballGame();

        frame.add(game);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setVisible(true);
    }
}

