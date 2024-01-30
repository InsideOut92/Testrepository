package Pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PongGame extends JPanel {
    private Ball ball;
    private Paddle userPaddle;
    private Paddle computerPaddle;
    private int mouseY;
    private int player1Score = 0;
    private int player2Score = 0;
    private int ballCollisions = 0; // Zähler für Ballkollisionen

    public PongGame(Ball ball, Paddle userPaddle, Paddle computerPaddle) {
        this.ball = ball;
        this.userPaddle = userPaddle;
        this.computerPaddle = computerPaddle;

        addMouseMotionListener(new PongMouseMotionAdapter());
        setFocusable(true);
        requestFocus();
        addKeyListener(new PongKeyListener());
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        ball.paint(g);
        userPaddle.paint(g);
        computerPaddle.paint(g);

        // Zeichne den Punktestand
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString("Player 1: " + player1Score, 20, 30);
        g.drawString("Player 2: " + player2Score, getWidth() - 120, 30);
    }

    public void updateGame() {
        ball.move();
        ball.bounce(getWidth(), getHeight());
        ball.checkPaddleCollision(userPaddle);
        ball.checkPaddleCollision(computerPaddle);

        checkBallCollisions(); // Überprüfe Ballkollisionen

        userPaddle.move(mouseY);
        computerPaddle.move(ball.getY());

        repaint();
    }

    private void checkBallCollisions() {
        // Überprüfe alle 5 Ballkollisionen mit einem der Paddles
        if (ballCollisions >= 5) {
            ball.increaseSpeed(); // Erhöhe die Geschwindigkeit des Balls
            ballCollisions = 0; // Setze den Zähler zurück
        }
    }

    private void checkScoring() {
        if (ball.getX() - ball.getSize() / 2 < 0) {
            player2Score++;
            checkPaddleSize();
            // Ball zurücksetzen, wenn Spieler 2 zwei oder mehr Punkte hat und mehr Punkte als Spieler 1
            if (player2Score >= 2 && player2Score > player1Score) {
                // resetBall();
            }
        } else if (ball.getX() + ball.getSize() / 2 > getWidth()) {
            player1Score++;
            checkPaddleSize();
            // Ball zurücksetzen, wenn Spieler 1 zwei oder mehr Punkte hat und mehr Punkte als Spieler 2
            if (player1Score >= 2 && player1Score > player2Score) {
                // resetBall();
            }
        }
    }

    private void checkPaddleSize() {
        if (player1Score - player2Score >= 2) {
            userPaddle.decreaseSize();
        } else if (player2Score - player1Score >= 2) {
            userPaddle.resetSize();
        }
    }

    private void resetBall() {
        ball.setX(getWidth() / 2);
        ball.setY(getHeight() / 2);
    }

    private class PongMouseMotionAdapter extends MouseMotionAdapter {
        @Override
        public void mouseMoved(MouseEvent e) {
            mouseY = e.getY();
        }
    }

    private class PongKeyListener extends KeyAdapter {
        @Override
        public void keyPressed(KeyEvent e) {
            switch (e.getKeyCode()) {
                case KeyEvent.VK_UP:
                    userPaddle.moveUP();
                    break;
                case KeyEvent.VK_DOWN:
                    userPaddle.moveDOWN(getHeight());
                    break;
            }
        }
    }
}
