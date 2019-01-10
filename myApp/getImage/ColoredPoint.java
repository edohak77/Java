package homework.myApp.getImage;


import java.awt.*;

public class ColoredPoint {
    private Point point;
    private Color color;

    public ColoredPoint(Color color, Point point) {
        this.point = point;
        this.color = color;
    }

    public Point getPoint() {
        return point;
    }

    public Color getColor() {
        return color;
    }
}
