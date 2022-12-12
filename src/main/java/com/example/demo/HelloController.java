package com.example.demo;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    private TextField textValue;

    @FXML
    AnchorPane resultsPane;

    @FXML
    private TextArea resultsField;

    @FXML
    private CheckBox climateTask;

    @FXML
    private CheckBox infotainmentTask;

    @FXML
    private CheckBox gpsTask;

    @FXML
    private TextField aperiodicTaskArrival;



    @FXML
    protected void onScheduleClick(){
        resultsField.setText("Scheduling.....");

        TestThreads th = new TestThreads();

        List<TaskNew> tasksList = new ArrayList<>();

        String[] aperiodicTaskArr=null;
        if(aperiodicTaskArrival!=null){
            aperiodicTaskArr = aperiodicTaskArrival.getText().split(" ");
        }



        if(climateTask.isSelected()){
            TaskNew t1 = new TaskNew(2,8,"Climate Control Task");
            tasksList.add(t1);

        }
        if(infotainmentTask.isSelected()){

            TaskNew t2 = new TaskNew(3,12, "Infotainment Task");
            tasksList.add(t2);

        }
        if(gpsTask.isSelected()){
            TaskNew t3 = new TaskNew(4,16, "GPS Task");
            tasksList.add(t3);
        }

        List<TaskNew> list = TestThreads.runSchedule(tasksList, aperiodicTaskArr);






        int counter=0;
        for(TaskNew task : list){
            String existingData= resultsField.getText();
            if(task != null) {
                resultsField.setText(existingData+"\n"+"At time " + counter + " , " + task.getName());
            } else{
                resultsField.setText(existingData+"\n"+"At time " + counter + " , " +"No task executed \n");
            }
            counter++;
        }


//        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), new EventHandler<ActionEvent>() {
//
//            private int i = 1;
//
//            @Override
//            public void handle(ActionEvent event) {
//                resultsField.setText(resultsField.getText()+"\n"+ i);
//                i++;
//            }
//        }));
//        timeline.setCycleCount(10);
//        timeline.play();
    }




}