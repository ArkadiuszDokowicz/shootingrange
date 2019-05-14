package shootingrange;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Ellipse;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class Controller   {

    private static int probe =100;


    @FXML
    private Button button1;
    @FXML
    private AnchorPane container;
    @FXML
    private TextArea info;
    @FXML
    private Label label;

    private volatile int generationCounter=0;
    private List<Point> shots = new ArrayList();
    private Shooter shooter=new Shooter(shots,10,2);
    private boolean firstShootingRound= true;


    public void shootingButton(ActionEvent event){
        this.info.setText("");
        generationCounter++;
        this.label.setText("Generation :"+this.generationCounter);
        if(firstShootingRound==true){
            this.button1.setText("Next Generation");
            shooter.firstShootingRound();
            firstShootingRound=false;
        }
        else{
            shooter.nextShootingRound();
        }
    }

    public void shootingButton2(ActionEvent event) {
        this.restartShooting();

    }

    private void restartShooting(){
        this.button1.setText("First Generation");
        this.generationCounter=0;
        this.label.setText("Generation :"+this.generationCounter);
        for( Point shot:shots) {
            EllipseService.hidePoint(shot.getEllipse());
            EllipseService.setPosition(shot.getEllipse(),0,0,shot.getEllipse().getRadiusX(),shot.getEllipse().getRadiusX());
            EllipseService.setColor(shot.getEllipse(), Color.BLACK);
            firstShootingRound=true;
            this.info.setText("");
        }
    }
    private void setPopulation(int value){
        this.probe=value;
        System.out.println(this.probe);
    };
    private void PopulationSliderInitialize(){

        final Slider populationSlider = new Slider();
        populationSlider.setMin(20);
        populationSlider.setMax(100);
        populationSlider.setValue(40);
        populationSlider.setShowTickLabels(true);
        populationSlider.setShowTickMarks(true);
        populationSlider.setMajorTickUnit(50);
        populationSlider.setMinorTickCount(5);
        populationSlider.setBlockIncrement(10);
        populationSlider.setLayoutX(200);
        populationSlider.setLayoutY(400);
        populationSlider.addEventFilter(MouseEvent.MOUSE_RELEASED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                setPopulation((int)populationSlider.getValue());
                restartShooting();
                shootsInitialize();

            }
        });

        final Label populationCaption = new Label("Population:");
        final Label populationValue = new Label(
                Double.toString(populationSlider.getValue()));


        populationCaption.setLayoutX(populationSlider.getLayoutX()-80);populationCaption.setLayoutY(400);
        populationSlider.valueProperty().addListener(new ChangeListener<Number>() {
            public synchronized void changed(ObservableValue<? extends Number> ov,Number old_val, Number new_val) {
                Double value= (Double) new_val;
                System.out.println(value);
                populationValue.setText(String.format("%.0f", new_val));
            }});
        populationValue.setLayoutX(populationSlider.getLayoutX()+150);populationValue.setLayoutY(400);
        container.getChildren().addAll(populationSlider,populationValue,populationCaption);
        setPopulation((int)populationSlider.getValue());

    }

    public void shootsInitialize(){
        this.shots.clear();
        for (int i = 1; i <= probe; i++) {
            Ellipse ellipse = new Ellipse();
            ellipse.addEventFilter(MouseEvent.MOUSE_MOVED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    DecimalFormat df2 = new DecimalFormat("#.##");
                    Ellipse ellipse = (Ellipse) mouseEvent.getSource();
                    Point point=shooter.getPointById(ellipse.getId());
                    info.setText(point.toString());
                    info.appendText("\nx:"+df2.format(point.getEllipse().getLayoutX())+" y:"+df2.format(point.getEllipse().getLayoutY())+" mark:"+point.getValue());
                }
            });
            shots.add(new Point("shoot"+i,ellipse,0));
            ellipse.setId("shoot"+i);
            container.getChildren().add(ellipse);
        }
        System.out.println(this.shots.size()+" shoots created");
        shooter.setShots(shots);

    }


    public void initialize() {
        this.PopulationSliderInitialize();
        this.shootsInitialize();
        this.button1.setText("First Generation");
    }
}
