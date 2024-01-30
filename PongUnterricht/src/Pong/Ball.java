package Pong;

import java.awt.*;

public class Ball {
    // Attribute
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
        g.setColor(color);
        g.fillOval(x, y, size, size);
    }

    public void moveBall(){
        x += vx;
        y += vy;
    }

    public void bounceEdges(int width, int height){
        // Wenn y negativ wird, sind wir links aus dem Rand raus -> umkehren
        if(y < 0){
            reverseY();
        } else if ( y > height - size){
            // Wenn wir über den rechten Bildschirmrand kommen -> umkehren
            reverseY();
        };

        if(x < 0){
            // Wenn wir über den oberen Bildschirmrand kommen -> umkehren
            reverseX();
        } else if (x > (width - size)) {
            // Wenn wir über den unteren Bildschirmrand kommen -> umkehren
            reverseX();
        }
    }

    @Override
    public String toString() {
        return "Aktuelle Position: " + this.x + " : " + this.y;
    }

    public void reverseX(){
        vx *= -1;
    }

    public void reverseY(){
        vy *= -1;
    }
}
