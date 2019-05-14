package shootingrange;

import java.util.List;

public class Shield {
    //center 250X 180Y
    //ellipses radius :
    // rad.5 rank 10
    //rad.20 rank 9
    //rad.40 rank 8
    //rad.60 rank 7
    //rad.90 rank 5
    //rad.120 rank 3
    //rad.150 rank 2
    //rad.170 rank 1
   private Double layoutX=250.d;
   private Double layoutY=180.d;
   private int rad1=5;   //10
   private int rad2=20;  //9
   private int rad3=40;  //8
   private int rad4=60;  //7
   private int rad5=90;  //5
   private int rad6=120; //3
   private int rad7=150; //2
   private int rad8=170; //1





   public void rateShots(List<Point> shots){
       for(Point point:shots){
           this.rateShot(point);
       }
   }
    static boolean isInside(double circle_x, double circle_y,int rad, double x, double y)
    {
        // Compare radius of circle with
        // distance of its center from
        // given point
        if ((x - circle_x) * (x - circle_x) +
                (y - circle_y) * (y - circle_y) <= rad * rad)
            return true;
        else
            return false;
    }

    private void rateShot(Point point){
       double pointLayoutX=point.getEllipse().getLayoutX();
       double pointLayoutY=point.getEllipse().getLayoutY();
       if(isInside(layoutX,layoutY,rad1,pointLayoutX,pointLayoutY)){
           point.setValue(10);
       }
       else if(isInside(layoutX,layoutY,rad2,pointLayoutX,pointLayoutY)){
            point.setValue(9);
        }
       else if(isInside(layoutX,layoutY,rad3,pointLayoutX,pointLayoutY)){
           point.setValue(8);
       }
       else if(isInside(layoutX,layoutY,rad4,pointLayoutX,pointLayoutY)){
           point.setValue(7);
       }
       else if(isInside(layoutX,layoutY,rad5,pointLayoutX,pointLayoutY)){
           point.setValue(5);
       }
       else if(isInside(layoutX,layoutY,rad6,pointLayoutX,pointLayoutY)){
           point.setValue(3);
       }
       else if(isInside(layoutX,layoutY,rad7,pointLayoutX,pointLayoutY)){
           point.setValue(2);
       }
       else if(isInside(layoutX,layoutY,rad8,pointLayoutX,pointLayoutY)){
           point.setValue(1);
       }
       else{point.setValue(0);}

   }
   private boolean between(double i, double minValueInclusive, double maxValueInclusive) {
        if (i >= minValueInclusive && i <= maxValueInclusive) {
            return true;
        }
        else
            return false;
    }

}
