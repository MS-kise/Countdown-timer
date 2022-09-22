package com.company;

public class Task {
    String name;
    int minute;
    int second;

    public Task(String name, int minute, int second){
        this.name = name;
        this.minute = minute;
        this.second = second;
    }
    public String getName(){
        return name;
    }
    public int getMinute(){
        return minute;
    }
    public int getSecond(){
        return second;
    }
}