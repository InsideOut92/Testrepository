package Pong;

import javax.swing.*;
import java.awt.*;

public class PongFrame extends JFrame {
    private PongGame pongGame;

    public PongFrame() {
        Ball ball = new Ball(320, 240, 2, 2, 20, Color.WHITE);
        Paddle userPaddle = new Paddle(10, 160, 20, 80, 5, Color.GREEN);
        Paddle computerPaddle = new Paddle(610, 160, 20, 80, 5, Color.RED);

        pongGame = new PongGame(ball, userPaddle, computerPaddle);

        setLayout(new BorderLayout());
        add(pongGame, BorderLayout.CENTER);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640, 480);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void startGameLoop() {
        Timer timer = new Timer(10, e -> pongGame.updateGame());
        timer.start();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            PongFrame pongFrame = new PongFrame();
            pongFrame.startGameLoop();
        });
    }
}
