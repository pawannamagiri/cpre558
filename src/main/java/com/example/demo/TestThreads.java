package com.example.demo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Author @ Pawan Namagiri
 **/


public class TestThreads {

    static boolean globalFlag =false;

    static int timer =0;

    public static List<TaskNew> runSchedule(List<TaskNew> tasksList, String[] aperiodicTaskArrival) {

        Thread poller = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                    globalFlag = true;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        List<Integer> aperiodicArrivalTimeList = new ArrayList<>();
        if(aperiodicTaskArrival!=null){
            for(String str: aperiodicTaskArrival) aperiodicArrivalTimeList.add(Integer.valueOf(str));
        }


        int lcm = calcLCM(tasksList);
        List<TaskNew> waitingList = new ArrayList<>();
        List<TaskNew> outList = new ArrayList<>();

//        poller.start();

        for(int timeUnit = 0; timeUnit < lcm; timeUnit++){

            //add iterative tasks into the waiting list

            for(TaskNew p : tasksList)
                if(timeUnit % p.getPeriod() == 0) {
                    for (int i = 1; i <= p.geteT(); i++) {

                        if (!aperiodicArrivalTimeList.isEmpty() && aperiodicArrivalTimeList.contains(timeUnit)) {

                            for (int j = 0; j < 3; j++) {
                                outList.add(new TaskNew("Aperiodic Task: Emergency braking"));

                            }

                            int index = aperiodicArrivalTimeList.indexOf(timeUnit);

                            aperiodicArrivalTimeList.remove(index);

                        }

                        waitingList.add(p);
                        timer++;
                    }
                }

            if(! waitingList.isEmpty()) {


                //the highest priority task has the minimum period
                Collections.sort(waitingList);
                outList.add(waitingList.get(0));
                waitingList.remove(0);
            } else
                outList.add(null);



        }







        int counter=0;
        for(TaskNew task : outList){
            if(task != null) {
                System.out.println("At time " + counter + " , " + task.getName() + " ci is " + task.geteT());
            }
            counter++;
        }
    return  outList;

    }




    static int calcLCM(List<TaskNew> taskList) {

        int lcm = taskList.get(0).getPeriod();
        for(boolean flag = true; flag; ) {
            for(TaskNew x : taskList) {
                if(lcm % x.getPeriod() != 0) {
                    flag = true;
                    break;
                }
                flag = false;
            }
            lcm = flag? (lcm + 1) : lcm;
        }

        return lcm;
    }
}
