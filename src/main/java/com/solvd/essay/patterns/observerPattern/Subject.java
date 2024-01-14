package com.solvd.essay.patterns.observerPattern;

public interface Subject {
    public void register(Observer observer);
    public void unregister(Observer observer);
    public void notifyObservers();
    public String getUpdate(Observer observer);
}
