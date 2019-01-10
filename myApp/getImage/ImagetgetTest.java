package homework.myApp.getImage;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ImagetgetTest {
    public static void main(String[] args) throws IOException, InterruptedException, AWTException {
        BufferedImage img = null;
        Process process = new ProcessBuilder("/usr/bin/pinta").start();
//
//        Thread.sleep(5_000);
//
//        img = ImageIO.read(new File("/home/eduard/Pictures/1.jpg"));
//        Color[][] imgPixeles = new Color[img.getWidth()][img.getHeight()];


        Robot robot= new Robot();
        robot.delay(2000);
        robot.mouseMove(15,545);

//        //load image in matrix
//        for (int i = 0; i < img.getWidth(); i++) {
//            for (int j = 0; j < img.getHeight(); j++) {
//                Color px = new Color(img.getRGB(i,j));
//                imgPixeles[i][j] = px;
//            }
//            System.out.println();
//        }
//
//        for (int i = 359,k=0; k < imgPixeles[0].length; i++,k++) {
//            for (int j = 251,l=0; l < imgPixeles.length; j++,l++) {
//                robot.mouseMove(j,i);
//                robot.mousePress(InputEvent.BUTTON1_MASK);
//                Thread.sleep(6);
//                robot.mouseRelease(InputEvent.BUTTON1_MASK);
//                Thread.sleep(8);
//            }
//        }
//
//
    }
}
