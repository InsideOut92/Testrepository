// Gegner wird nicht dargestellt!!!
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Spiel extends JFrame implements KeyListener {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;

    private final int PADDLE_WIDTH = 20;
    private final int PADDLE_HEIGHT = 60;
    private final int BALL_SIZE = 20;

    private int paddleYLeft = HEIGHT / 2;
    private int paddleYRight = HEIGHT / 2;
    private int ballX = WIDTH / 2;
    private int ballY = HEIGHT / 2;
    private int ballSpeedX = 2;
    private int ballSpeedY = 1;

    private int rightPaddleSpeed = 2;
    private int rightPaddleDifficulty = 1;

    public Spiel() {
        setupGameWindow();
        selectDifficulty();
    }

    private void setupGameWindow() {
        setTitle("Mein Pong Spiel");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);

        addKeyListener(this);

        GameCanvas canvas = new GameCanvas();
        add(canvas);
    }

    public void start() {
        setVisible(true);

        Timer timer = new Timer(10, e -> {
            update();
            repaint();
        });
        timer.start();
    }

    private void update() {
        moveBall();
        handleBallWallCollision();
        handleBallPaddleCollision();

        updateRightPaddle();
        handleRightPaddleCollision();

        handleBallOut();
    }

    private void moveBall() {
        ballX += ballSpeedX;
        ballY += ballSpeedY;
    }

    private void handleBallWallCollision() {
        if (ballY <= 0 || ballY >= HEIGHT - BALL_SIZE) {
            ballSpeedY = -ballSpeedY;
        }
    }

    private void handleBallPaddleCollision() {
        if (ballX <= PADDLE_WIDTH + BALL_SIZE &&
                ballY >= paddleYLeft && ballY <= paddleYLeft + PADDLE_HEIGHT) {
            ballSpeedX = -ballSpeedX;
        }

        if (ballX >= WIDTH - PADDLE_WIDTH - BALL_SIZE &&
                ballY >= paddleYRight && ballY <= paddleYRight + PADDLE_HEIGHT) {
            ballSpeedX = -ballSpeedX;
        }
    }

    private void updateRightPaddle() {
        switch (rightPaddleDifficulty) {
            case 1:
                simpleRightPaddle();
                break;
            case 2:
                mediumRightPaddle();
                break;
            case 3:
                hardRightPaddle();
                break;
            default:
                throw new IllegalArgumentException("Ungültige Schwierigkeitsstufe");
        }
    }

    private void simpleRightPaddle() {
        if (paddleYRight + PADDLE_HEIGHT / 2 < ballY) {
            paddleYRight += rightPaddleSpeed;
        } else if (paddleYRight + PADDLE_HEIGHT / 2 > ballY) {
            paddleYRight -= rightPaddleSpeed;
        }
    }

    private void mediumRightPaddle() {
        if (paddleYRight + PADDLE_HEIGHT / 2 < ballY - 20) {
            paddleYRight += rightPaddleSpeed;
        } else if (paddleYRight + PADDLE_HEIGHT / 2 > ballY + 20) {
            paddleYRight -= rightPaddleSpeed;
        }
    }

    private void hardRightPaddle() {
        if (paddleYRight + PADDLE_HEIGHT / 2 < ballY) {
            paddleYRight += rightPaddleSpeed;
        } else if (paddleYRight + PADDLE_HEIGHT / 2 > ballY) {
            paddleYRight -= rightPaddleSpeed;
        }
    }

    private void handleRightPaddleCollision() {
        if (ballX >= WIDTH - PADDLE_WIDTH - BALL_SIZE &&
                ballY >= paddleYRight && ballY <= paddleYRight + PADDLE_HEIGHT) {
            ballSpeedX = -ballSpeedX;
        }
    }

    private void handleBallOut() {
        if (ballX <= 0 || ballX >= WIDTH) {
            resetBall();
        }
    }

    private void resetBall() {
        ballX = WIDTH / 2;
        ballY = HEIGHT / 2;
        ballSpeedX = -ballSpeedX;
    }

    public void setPaddleYLeft(int mouseY) {
        paddleYLeft = mouseY;
    }

    public void setPaddleYRight(int mouseY) {
        paddleYRight = mouseY;
    }

    public void setRightPaddleDifficulty(int difficulty) {
        rightPaddleDifficulty = difficulty;
    }

    private void selectDifficulty() {
        String input = JOptionPane.showInputDialog("Wähle die Schwierigkeitsstufe (1-3):");
        try {
            rightPaddleDifficulty = Integer.parseInt(input);
            if (rightPaddleDifficulty < 1 || rightPaddleDifficulty > 3) {
                System.out.println("Ungültige Eingabe. Schwierigkeitsstufe auf 1 gesetzt.");
                rightPaddleDifficulty = 1;
            }
        } catch (NumberFormatException e) {
            System.out.println("Ungültige Eingabe. Schwierigkeitsstufe auf 1 gesetzt.");
            rightPaddleDifficulty = 1;
        }
    }

    private class GameCanvas extends JPanel implements MouseMotionListener {
        public GameCanvas() {
            addMouseMotionListener(this);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            draw(g);
        }

        private void draw(Graphics g) {
            drawBackground(g);
            drawLeftPaddle(g);
            drawRightPaddle(g);
            drawBall(g);
        }

        private void drawBackground(Graphics g) {
            g.setColor(Color.BLACK);
            g.fillRect(0, 0, WIDTH, HEIGHT);
        }

        private void drawLeftPaddle(Graphics g) {
            g.setColor(Color.WHITE);
            g.fillRect(10, paddleYLeft, PADDLE_WIDTH, PADDLE_HEIGHT);
        }

        private void drawRightPaddle(Graphics g) {
            g.setColor(Color.WHITE);
            g.fillRect(WIDTH - 10 - PADDLE_WIDTH, paddleYRight, PADDLE_WIDTH, PADDLE_HEIGHT);
        }

        private void drawBall(Graphics g) {
            g.setColor(Color.WHITE);
            g.fillOval(ballX, ballY, BALL_SIZE, BALL_SIZE);
        }

        @Override
        public void mouseMoved(MouseEvent e) {
            // Nur für die linke Seite erforderlich, da die rechte Seite automatisch gesteuert wird
            setPaddleYLeft(e.getY());
        }

        @Override
        public void mouseDragged(MouseEvent e) {
            // Implementierung erforderlich, auch wenn leer, da MouseMotionListener
            setPaddleYLeft(e.getY());
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Platz für zukünftige Erweiterungen mit Tastensteuerung des linken Paddels
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // Platz für zukünftige Erweiterungen mit Tastensteuerung des linken Paddels
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Platz für zukünftige Erweiterungen mit Tastensteuerung des linken Paddels
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Spiel game = new Spiel();
            game.start();
        });
    }
}
