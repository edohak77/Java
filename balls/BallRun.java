package learn.javafx.balls;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

public class BallRun extends Application {
    private static ArrayList<Ball>ballArrayList;
    private static final int numOfBalls = 7;
    private static final int width = 800;
    private static final int heigth = 400;

    public static void main(String[] args) {
        ballArrayList = new ArrayList<>();
        for (int i = 0; i < numOfBalls; i++) {
            ballArrayList.add(new Ball(rnd(25,750),rnd(25,350),10,randomColor()));
        }
        ballArrayList.get(0).setBombBall();
        ballArrayList.get(1).setGhostBall();
        launch(args);
    }
    AnimationTimer timer = new AnimationTimer() {

        @Override
        public void handle(long now) {
            for (Ball b: ballArrayList ) {
                if (b.getCenterX() + b.getRadius() >= width || b.getCenterX() <= b.getRadius()) b.dx*=-1;
                if (b.getCenterY() + b.getRadius() >= heigth || b.getCenterY() <= b.getRadius()) b.dy*=-1;

                isColind(b);
                b.setCenterX(b.getCenterX() + b.dx);
                b.setCenterY(b.getCenterY() + b.dy);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }

    };
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        for (int i = 0; i < ballArrayList.size(); i++) {
            root.getChildren().add(ballArrayList.get(i));
        }


        timer.start();

        Scene scene = new Scene(root,width,heigth,Color.BLACK);
        primaryStage.setTitle("Ball board");
        primaryStage.setScene(scene);


        primaryStage.show();

    }

    public static void isColind(Ball ball){
        for (Ball cir: ballArrayList ) {
            if (!ball.equals(cir)) {
                double a = Math.abs(ball.getCenterX() - cir.getCenterX());
                double b = Math.abs(ball.getCenterY() - cir.getCenterY());
                double c = Math.sqrt(Math.pow(a, 2) + Math.pow(b, 2));

                if (cir.idBall == 2 || ball.idBall == 2) {
                    continue;
                }else {
                    if (c <= 2 * ball.getRadius()) {
                        if (cir.idBall == 1 || ball.idBall == 1) {
                            ballArrayList.remove(cir);
                            ballArrayList.remove(ball);
                            return;
                        }
                        cir.dx *= -1;
                        cir.dy *= -1;

                        ball.dx *= -1;
                        ball.dy *= -1;
                    }


                }
            }
        }
    }


    public static int rnd(int min, int max)
    {
        max -= min;
        return (int) (Math.random() * ++max) + min;
    }
    public static Color randomColor() {
        Random r = new Random();
        Color randomColor = new Color(r.nextDouble(), r.nextDouble(), r.nextDouble(),1);
        return randomColor;
    }
}
