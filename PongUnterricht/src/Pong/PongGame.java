package Pong;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class PongGame extends JPanel implements MouseMotionListener {
    // Attribute
    private static final int PANEL_WIDTH = 640, PANEL_HEIGHT = 480;
/* Identisch zu Zeile 7:
private static final int PANEL_WIDTH = 640;
private static final int PANEL_HEIGHT = 480;
*/

    private Ball gameBall;
    private Paddle user1Paddle, user2Paddle;
    private int userMouseY;
    private int keyboardY;


    public PongGame(){
        gameBall = new Ball(315, 235, 2, 2, 1, 10, Color.WHITE);
        user1Paddle = new Paddle(10, 160, 75, 3, Color.GREEN);
        user2Paddle = new Paddle(615, 160, 75, 3, Color.WHITE);

        userMouseY = 0;
        keyboardY = 0;

    }

    public void paintComponent(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0, 0, PANEL_WIDTH, PANEL_HEIGHT);

        gameBall.paint(g);
        user1Paddle.paint(g);
        user2Paddle.paint(g);
        addMouseMotionListener(this);
        //Erforderlich damit der KeyListener funktioniert
        this.setFocusable(true);
        this.requestFocus();
        addKeyListener(this);
    }

    public void gameLogic(){
        gameBall.moveBall();
        //System.out.println(gameBall.toString());
        gameBall.bounceEdges(PANEL_WIDTH, PANEL_HEIGHT);
        user1Paddle.moveTowards(userMouseY);
        user2Paddle.moveTowards(400);
    }

    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {
        userMouseY = e.getY();
    }

    @Override
    public void keyTyped(KeyEvent e){


        }



    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("Space pressed");
            keyboardY = 0;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            keyboardY = PANEL_HEIGHT;
            System.out.println("Down pressed");
        }
    }

    @Override
    public void keyReleased(KeyEvent e){

    }



    }
