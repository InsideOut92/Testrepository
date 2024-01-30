package Pong;

import java.awt.*;

public class Paddle {
    private int x, y, height;
    private int speed;
    private Color color;

    private static final int PADDLE_WIDTH = 15;

    public Paddle(int x, int y, int height, int speed, Color color) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.speed = speed;
        this.color = color;
    }

    public void paint(Graphics g){
        // Malt die Schläger bei Aufruf
        g.setColor(color);
        g.fillRect(x, y, PADDLE_WIDTH, height);
    }

    public void moveTowards(int moveToY){
        // Bewegt den Mittelpunkt des Schlägers zum Punkt moveToY
        int centerY = y + height / 2;
        // Berechnung Mittelpunkt Schläger

        // Bewegung nur, wenn der Abstand von Mittelpunkt und Zielposition größer ist als die Geschwindigkeit
        if(Math.abs(centerY - moveToY) > speed){
            if(centerY > moveToY){
                y -= speed;
            }

            if(centerY < moveToY){
                y += speed;
            }
        }
    }
}
