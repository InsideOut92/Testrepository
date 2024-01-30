package Pong;

import java.awt.*;

public class Paddle extends AbstractClass {
    private int x, y, width, height, speed;
    private Color color;
    private int initialHeight;

    public Paddle(int x, int y, int width, int height, int speed, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.speed = speed;
        this.color = color;
        this.initialHeight = height;
    }

    //Getter für X-Position Paddle
    public int getX(){
        return x;
    }

    //Getter für Y-Position Paddle
    public int getY(){
        return y;
    }

    //Getter für Breite Paddle
    public int getWidth(){
        return width;
    }

    // Getter für Höhe Paddle
    public int getHeight(){
        return height;
    }

    //Setter für Höhe Paddle
    public void setHeight(int height){
        this.height = height;
    }

    //Rücksetzen des Paddles
    public void resetSize(){
        height = initialHeight;
    }

    //Verringern Höhe Paddle
    public void decreaseSize(){
        height /= 2;
    }

    public void move(int mouseY) {
        y = mouseY - height / 2;
        checkBounds();
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillRect(x, y, width, height);
    }

    //Bewegung Paddle nach oben
    public void moveUP(){
        y -= speed;
        checkBounds();
    }

    //Bewegung Paddle nach unten
    public void moveDOWN(int screenHeight){
        y += speed;
        checkBounds(screenHeight);
    }

    // Spielfeldrandprüfung für Paddle
    private void checkBounds(){
        if(y < 0){
            y = 0;
        }
    }

    //Spielfeldrandprüfung
    private void checkBounds(int screenHeight){
        if(y + height > screenHeight){
            y = screenHeight - height;
        }
    }
}
