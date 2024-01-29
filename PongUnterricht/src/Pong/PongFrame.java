package Pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PongFrame {
    private static JFrame f = new JFrame("Patrick's Pong");
    private static final int WINDOW_WIDTH = 655, WINDOW_HEIGHT = 520;

    // Konstruktor
    public PongFrame() {
    }

    public void main(){
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(new Dimension(WINDOW_WIDTH, WINDOW_HEIGHT));
        f.setResizable(false);

        PongGame pong = new PongGame();
        f.add(pong);
        f.setVisible(true);

        Timer timer = new Timer(10, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pong.gameLogic();
                pong.repaint();

            }
        });
        timer.start();
    }
}
