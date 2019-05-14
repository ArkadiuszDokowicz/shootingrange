package shootingrange;

import javafx.scene.shape.Ellipse;

public class Point implements Comparable<Point>  {
    private String name;
    private Ellipse ellipse;
    private int value;
    private String ancestry1,ancestry2;

    public Point(String name, Ellipse ellipse, int value) {
        this.name = name;
        this.ellipse = ellipse;
        this.value = value;
    }


    public String getAncestry1() {
        return ancestry1;
    }

    public void setAncestry1(String ancestry1) {
        this.ancestry1 = ancestry1;
    }

    public String getAncestry2() {
        return ancestry2;
    }

    public void setAncestry2(String ancestry2) {
        this.ancestry2 = ancestry2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Ellipse getEllipse() {
        return ellipse;
    }

    public void setEllipse(Ellipse ellipse) {
        this.ellipse = ellipse;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Point{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Point obj) {
        int compareage=((Point)obj).getValue();
        /* For Ascending order*/
        return compareage-this.getValue();
    }
}

