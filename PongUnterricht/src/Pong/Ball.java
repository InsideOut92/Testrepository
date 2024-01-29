package Pong;

import java.awt.*;

public class Ball {
    //Attribute
    private int x, y;
    private int vx, vy;
    private int speed;
    private int size;
    private Color color;

    // Konstruktor

    public Ball(int x, int y, int vx, int vy, int speed, int size, Color color) {
        this.x = x;
        this.y = y;
        this.vx = vx;
        this.vy = vy;
        this.speed = speed;
        this.size = size;
        this.color = color;
    }

    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(x, y, size, size);
    }

    public void moveBall(){
        x += vx;
        y += vy;
    }

    public void bounceEdges(int width, int height){
        if(y < 0){
            reverseY();
        } else if (x > height - size) {
            reverseY();
        };

        if( x < 0){
            reverseX();
        } else if (x > (width - size)) {
            reverseX();
        }
    }
    @Override
    public String toString(){
        return "Aktuelle Position: " + this.x + " : " + this.y;

    }
    public void reverseX(){
        vx *= -1;
    }

    public void reverseY(){
        vy *= -1;
    }
}
