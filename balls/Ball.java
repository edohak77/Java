package learn.javafx.balls;

import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.ArrayList;

public class Ball extends Circle {
    public double dx =1;
    public double dy =1;
    public int idBall = 0;


    public Ball(double radius) {
        super(radius);
    }

    public Ball(double radius, Paint fill) {
        super(radius, fill);
    }

    public Ball() {
    }

    public Ball(double centerX, double centerY, double radius) {
        super(centerX, centerY, radius);
    }

    public Ball(double centerX, double centerY, double radius, Paint fill) {
        super(centerX, centerY, radius, fill);
    }

    public void move(int width,int heigth){
        if (this.getCenterX() + this.getRadius() >= 800 || this.getCenterX() <= this.getRadius()){
            this.dx*=-1;
        }
        if (this.getCenterY() + this.getRadius() >= 400 || this.getCenterY() <= this.getRadius()){
            this.dy*=-1;
        }
        this.setCenterX(this.getCenterX() + this.dx);
        this.setCenterY(this.getCenterX() + this.dy);
    }

    public void colide(ArrayList<Ball>balls){
        for (int i = 0; i < balls.size(); i++) {
            if (balls.get(i) != this){
                if (Math.abs(this.getCenterX() - balls.get(i).getCenterX()) <= this.getRadius()) {
                    this.dx *= -1;
                    balls.get(i).dx*=-1;
                }
                if (Math.abs(this.getCenterY() - balls.get(i).getCenterY()) <= this.getRadius()) {
                    this.dy *= -1;
                    balls.get(i).dy*=-1;
                }
            }

        }
    }

    public void setBombBall(){
        this.idBall = 1;
        this.setFill(Color.BLACK);
        this.setStroke(Color.RED);
        this.setStrokeWidth(6);
        this.setRadius(10);
    }

    public void setGhostBall(){
        this.idBall = 2;
        this.setFill(Color.ALICEBLUE);
        this.setStroke(Color.BLUE);
        this.setStrokeWidth(6);
        this.setRadius(10);
    }
}
