package Pong;

import javax.swing.*;
import java.awt.*;

public class PongGame extends JPanel {
    // Attribute
    private static final int PANEL_WIDHT = 640, PANEL_HEIGHT = 480;
    // Alternative: (identisch zu Zeile 7)
    // private static final int PANEL_WIDTH = 640;
    // private static final int PANEL_HEIGHT = 480;

    private  Ball gameBall;

    public PongGame() {
        gameBall = new Ball(315, 235, 2, 2, 1, 10, Color.BLACK);
    }
    public void paintComponent(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, PANEL_WIDHT, PANEL_HEIGHT);

        gameBall.paint(g);
    }

    public void gameLogic(){
        gameBall.moveBall();
        System.out.println(gameBall.toString());
        System.out.println();
        gameBall.bounceEdges(PANEL_WIDHT, PANEL_HEIGHT);

    }

}
