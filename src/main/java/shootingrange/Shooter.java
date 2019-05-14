package shootingrange;

import javafx.event.ActionEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Shooter extends geneticAlgorithm {
    private List<Point> shots = new ArrayList();
    Shield shield=new Shield();
    Shooter(List<Point> list,int tolerance, int mutation){
        super(tolerance,mutation);
        this.shots=list;

    }

    public List<Point> getShots() {
        return shots;
    }

    public void setShots(List<Point> shots) {
        this.shots = shots;
    }

    public void firstShootingRound(){
        this.prepareToShooting();
        Random rand = new Random();
        double rangeMin=0;
        double rangeMax=400;
        for( Point shot:shots) {
            Double randomX  =rangeMin + (rangeMax - rangeMin) * rand.nextDouble();
           // System.out.println(randomX);
            Double randomY  =rangeMin + (rangeMax - rangeMin) * rand.nextDouble();
           // System.out.println(randomY);
            EllipseService.setPosition(shot.getEllipse(), randomX, randomY, 3, 3);
        }
        this.checkTheResults();
        this.Selection(this.shots);
        this.setParents(this.shots);
        this.readResults();//it prints to console only
    }
    public void nextShootingRound(){
        this.crossover(this.shots);
        this.mutation(this.shots);
        this.checkTheResults();
        this.Selection(this.shots);
        this.setParents(this.shots);
        this.readResults();//it prints to console only
    }
    public void checkTheResults(){
    shield.rateShots(shots);
    }

    public void readResults(){
        for(Point point:shots){
            System.out.print(point.getValue()+" ");
        }
        System.out.println();
    }

    public Point getPointById(String id){
        Point point = null;

        for(Point obj:shots){
            if((obj.getEllipse().getId()).equals(id)){
                point=obj;
            }
        }

        return point;
    }

    void prepareToShooting(){
        for(Point point:shots){point.setValue(0);}
    }
}

