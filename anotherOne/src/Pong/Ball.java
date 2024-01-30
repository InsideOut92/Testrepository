package Pong;

import java.awt.*;

public class Ball extends AbstractClass{
    private int x, y, speedX, speedY, size;
    private Color color;

    public Ball(int x, int y, int speedX, int speedY, int size, Color color) {
        this.x = x;
        this.y = y;
        this.speedX = speedX;
        this.speedY = speedY;
        this.size = size;
        this.color = color;
    }

    // Getter für die X-Position (Ball)
    public int getX(){
        return x;
    }

    // Getter für die Y-Position (Ball)
    public int getY(){
        return y;
    }

    // Getter für die Größe des Balls
    public int getSize(){
        return size;
    }

    // Setter für die X-Position (Balls)
    public void  setX(int x){
        this.x = x;
    }

    // Setter für die Y-Position (Ball)
    public void setY(int y){
        this.y = y;
    }

    // Ball basierend auf der Geschwindigkeit bewegen
    public void move() {
        x += speedX;
        y += speedY;
    }

    public void bounce(int screenWidth, int screenHeight) {
        if (x - size / 2 < 0 || x + size / 2 > screenWidth) {
            speedX = -speedX;
            // Erhöhe Geschwindigkeit
            increaseSpeed();
        }

        if (y - size / 2 < 0 || y + size / 2 > screenHeight) {
            speedY = -speedY;
        }
    }

    //Üperprüfung auf Kollision mit Paddle
    public void checkPaddleCollision(Paddle paddle){
        if(x - size / 2 < paddle.getX() + paddle.getWidth() &&
           x + size / 2 > paddle.getX() &&
           y - size / 2 < paddle.getY() + paddle.getHeight() &&
           y + size / 2 < paddle.getY()){
            speedX = -speedX;
            increaseSpeed();
        }
    }

    public void paint(Graphics g) {
        g.setColor(color);
        g.fillOval(x - size / 2, y - size / 2, size, size);
    }

    // Methode der Geschwindigkeitserhöhung nach Kollision
    public void increaseSpeed(){
        // Erhöhe Geschwindigkeit vom Ball um 10%
        speedX *= 1.10;
        speedY *= 1.10;
    }
}
