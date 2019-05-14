package shootingrange;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

public class EllipseService  {
    static public void hidePoint(Ellipse obj){
        obj.setLayoutX(0);
        obj.setLayoutY(0);
        obj.setRadiusX(0);
        obj.setRadiusY(0);

    }
    static public void setPosition(Ellipse obj,double layoutX,double layoutY,double RadiusX,double RadiusY){
        obj.setLayoutX(layoutX);
        obj.setLayoutY(layoutY);
        obj.setRadiusX(RadiusX);
        obj.setRadiusY(RadiusY);
    }
    static public void setColor(Ellipse obj, Color color){

        obj.setFill(color);
    }
}
