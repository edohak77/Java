package homework.myApp;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class PanitaColorPalette {

    public static Map<Color, Point> pallete;

    public PanitaColorPalette(){
        pallete = completeMap();
    }


    private Map<Color,Point> completeMap() {
        Map<Color, Point> tempMap = new HashMap<>();


        tempMap.put(new Color(255, 255, 255), new Point(15, 545));
        tempMap.put(new Color(0, 0, 0), new Point(30, 545));
        tempMap.put(new Color(160, 160, 160), new Point(45, 545));

        tempMap.put(new Color(128, 128, 128), new Point(15, 560));
        tempMap.put(new Color(64, 64, 64), new Point(30, 560));
        tempMap.put(new Color(48, 48, 48), new Point(45, 560));

        tempMap.put(new Color(127, 0, 0), new Point(15, 575));
        tempMap.put(new Color(255, 0, 0), new Point(30, 575));
        tempMap.put(new Color(255, 127, 127), new Point(45, 575));

        tempMap.put(new Color(127, 51, 0), new Point(15, 590));
        tempMap.put(new Color(255, 106, 0), new Point(30, 590));
        tempMap.put(new Color(255, 178, 127), new Point(45, 590));

        tempMap.put(new Color(127, 106, 0), new Point(15, 605));
        tempMap.put(new Color(255, 216, 0), new Point(30, 605));
        tempMap.put(new Color(255, 233, 127), new Point(45, 605));

        tempMap.put(new Color(91, 127, 0), new Point(15, 620));
        tempMap.put(new Color(182, 255, 0), new Point(30, 620));
        tempMap.put(new Color(218, 255, 127), new Point(45, 620));

        tempMap.put(new Color(38, 127, 0), new Point(15, 635));
        tempMap.put(new Color(76, 255, 0), new Point(30, 635));
        tempMap.put(new Color(165, 255, 127), new Point(45, 635));

        tempMap.put(new Color(0, 127, 14), new Point(15, 650));
        tempMap.put(new Color(0, 255, 33), new Point(30, 650));
        tempMap.put(new Color(127, 255, 147), new Point(45, 650));

        tempMap.put(new Color(0, 127, 70), new Point(15, 665));
        tempMap.put(new Color(0, 255, 144), new Point(30, 665));
        tempMap.put(new Color(127, 255, 197), new Point(45, 665));

        tempMap.put(new Color(0, 127, 127), new Point(15, 680));
        tempMap.put(new Color(0, 255, 255), new Point(30, 680));
        tempMap.put(new Color(127, 255, 255), new Point(45, 680));

        tempMap.put(new Color(0, 74, 127), new Point(15, 695));
        tempMap.put(new Color(0, 148, 255), new Point(30, 695));
        tempMap.put(new Color(127, 201, 255), new Point(45, 695));

        tempMap.put(new Color(0, 19, 127), new Point(15, 710));
        tempMap.put(new Color(0, 38, 255), new Point(30, 710));
        tempMap.put(new Color(127, 146, 255), new Point(45, 710));

        tempMap.put(new Color(33, 0, 127), new Point(15, 725));
        tempMap.put(new Color(72, 0, 255), new Point(30, 725));
        tempMap.put(new Color(161, 127, 255), new Point(45, 725));

        tempMap.put(new Color(87, 0, 127), new Point(15, 740));
        tempMap.put(new Color(178, 0, 255), new Point(30, 740));
        tempMap.put(new Color(214, 127, 255), new Point(45, 740));

        tempMap.put(new Color(127, 0, 110), new Point(15, 755));
        tempMap.put(new Color(255, 0, 220), new Point(30, 755));
        tempMap.put(new Color(255, 127, 237), new Point(45, 755));

        return tempMap;

    }
}
