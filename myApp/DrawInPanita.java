package homework.myApp;

import homework.myApp.getImage.ColoredPoint;
import sun.plugin2.util.ColorUtil;

import javax.imageio.ImageIO;
import javax.swing.plaf.synth.ColorType;
import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

import static javafx.scene.input.KeyCode.K;
import static javafx.scene.input.KeyCode.V;

public class DrawInPanita {
    public static PanitaColorPalette colorPalette;
    public static BufferedImage img;

    public static void main(String[] args) throws IOException, AWTException, InterruptedException {
        System.out.println("StartTerminal:  -> " + new Date());

        Process process = new ProcessBuilder("/usr/bin/pinta").start();

        colorPalette = new PanitaColorPalette();
        img = null;
        img = ImageIO.read(new File("/home/eduard/Pictures/1.jpg"));

        Color[][] imgPixeles = new Color[img.getWidth()][img.getHeight()];
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
                Color px = new Color(img.getRGB(i, j));
                imgPixeles[i][j] = px;
            }
        }

        ColoredPoint[][] imgMatrix = new ColoredPoint[img.getWidth()][img.getHeight()];
        ArrayList<ColoredPoint> listImg = new ArrayList<>();
        for (int i = 0; i < img.getWidth(); i++) {
            for (int j = 0; j < img.getHeight(); j++) {
//                imgMatrix[i][j] = new ColoredPoint(imgPixeles[i][j],new Point(i,j));
                listImg.add(new ColoredPoint(imgPixeles[i][j], new Point(i, j)));
            }
        }

        ColoredPoint[] pixeles = sortedArrayColorPoints(listImg);
//        ColoredPoint[] pixeles = listImg.toArray(new ColoredPoint[listImg.size()]);
        Thread.sleep(5000);

        int xStart = 339;
        int yStart = 251;
        Robot robot = new Robot();
        robot.mouseMove(15, 365);
        robot.mousePress(InputEvent.BUTTON1_MASK);
        robot.mouseRelease(InputEvent.BUTTON1_MASK);
        Thread.sleep(2000);

        robot.mouseMove(xStart, yStart);
        Point controlPix = new Point(0, 0);
        for (int i = 0; i < pixeles.length; i++) {
            ColoredPoint cp = pixeles[i];
            Color color = cp.getColor();
            Point pix = getcolourPoint(color);
            Point move = pixeles[i].getPoint();
//            if (!color.equals (new Color(255,255,255))) {
                if (!pix.equals(controlPix)) {
                    controlPix = new Point(pix.x, pix.y);

                    robot.mouseMove(pix.x, pix.y);
                    robot.mousePress(InputEvent.BUTTON1_MASK);
                    robot.mouseRelease(InputEvent.BUTTON1_MASK);
                    Thread.sleep(8);
                }
                robot.mouseRelease(InputEvent.BUTTON1_MASK);
                Thread.sleep(8);

                int x = (int) (339 + move.getX());
                int y = (int) (251 + move.getY());

                robot.mouseMove(150, 766);
                robot.keyPress(KeyEvent.VK_P);
                robot.keyRelease(KeyEvent.VK_P);
                Thread.sleep(5);
                robot.mouseMove(x, y);
                robot.mousePress(InputEvent.BUTTON1_MASK);
                robot.mouseRelease(InputEvent.BUTTON1_MASK);
                Thread.sleep(10);
//            }else {
////                System.out.println("WHITE");
//                continue;
//            }
        }
        System.out.println("Finish: -> " + new Date());

    }

    public static Map<Color, Point> matrixToMap(Color[][] matrix) {
        Map<Color, Point> imgtemp = new HashMap<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                Point p = new Point(j, i);
                Color col = matrix[i][j];
                imgtemp.put(col, p);
            }
        }
        return imgtemp;
    }

    public static Point getcolourPoint(Color e1) {
        colorPalette = new PanitaColorPalette();
        Map<Color, Point> palet = colorPalette.pallete;

        double min = (double) Integer.MAX_VALUE;
        Color col = null;
        Point point = null;
        for (Map.Entry<Color, Point> item : palet.entrySet()) {
            Color e2 = item.getKey();
            double fi = 30 * (Math.pow(((double) e1.getRed() - (double) e2.getRed()), 2)) +
                    59 * (Math.pow(((double) e1.getGreen() - (double) e2.getGreen()), 2)) +
                    11 * (Math.pow(((double) e1.getBlue() - (double) e2.getBlue()), 2));

            if (fi < min) {
                min = fi;
                col = e2;
                point = item.getValue();
            }
        }

        return point;
    }

    public static ColoredPoint[] sortedArrayColorPoints(ArrayList<ColoredPoint> cp) {


        ColoredPoint[] myArray = cp.toArray(new ColoredPoint[cp.size()]);

        Arrays.sort(myArray, new Comparator<ColoredPoint>() {
            @Override
            public int compare(ColoredPoint o1, ColoredPoint o2) {
                Color col1 = o1.getColor();
                Color col2 = o2.getColor();
                return col1.getRGB() - col2.getRGB();
            }
        });

        return myArray;
    }
}
