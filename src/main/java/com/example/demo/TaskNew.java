package com.example.demo;


public class TaskNew implements Comparable<TaskNew> {

    public static int getCount() {
        return count;
    }

    public static void setCount(int count) {
        TaskNew.count = count;
    }

    public int geteT() {
        return eT;
    }

    public void seteT(int eT) {
        this.eT = eT;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private static int count = 0;
    private  int eT;
    private  int period;
    private  int id;
    private  String name;


    public TaskNew(int eT, int period, String name) {
        this.eT = (eT);
        this.period =(period);
        this.id = (count);
        this.name = name;

    }

    public TaskNew(String name) {

        this.name = name;

    }



    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public int compareTo(TaskNew other) {
            return Integer.compare(this.getPeriod(), other.getPeriod());
    }
}
