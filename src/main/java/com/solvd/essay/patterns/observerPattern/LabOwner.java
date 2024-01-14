package com.solvd.essay.patterns.observerPattern;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LabOwner implements Subject {
    private List<Observer> observerList=new ArrayList<>();
    private String message;
    private boolean newNotification;

    private Object lock=new Object();
    @Override
    public void register(Observer observer) {
        if (observer == null) throw new NullPointerException("null observer");
        synchronized (lock) {
            if (!observerList.contains(observer)) {
                observerList.add(observer);
            }
        }
    }

    @Override
    public void unregister(Observer observer) {
        synchronized (lock) {
            if (observerList.contains(observer)) {
                observerList.remove(observer);
            } else {
                System.out.println("The observer does not exist");
            }
        }

    }

    @Override
    public void notifyObservers() {
        List<Observer> localObservers=null;
        synchronized (lock){
            if (!this.newNotification){
                return;
            }
            localObservers=this.observerList;
            this.newNotification=false;
        }
        for (Observer observer1:localObservers) {
            observer1.update();
        }
    }

    @Override
    public String getUpdate(Observer observer) {
        return this.message;
    }

    public void sendMessageSuppliers(String message){
        String newMessage=String.format("Message to suppliers date %s : %s", LocalDate.now(),message);
        System.out.println(newMessage);
        this.message=newMessage;
        this.newNotification=true;
    }
}
