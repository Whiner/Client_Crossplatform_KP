package com.donntu.kp.client.logger;

import com.donntu.kp.client.logger.observer.IObserver;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Log {
    private Log() {
    }

    private static Log instance;

    private LogBuffer logBuffer = new LogBuffer();

    private List<IObserver> observers = new ArrayList<>();

    public void subscribe(IObserver observer) {
        observers.add(observer);
    }

    private void notifyObservers(String log) {
        for (IObserver observer : observers) {
            observer.update(log);
        }
    }

    public static synchronized Log getInstance() {
        if (instance == null) {
            instance = new Log();
        }
        return instance;
    }

    public synchronized void log(String log) {
        notifyObservers(log);
        logBuffer.addLog(new Date().toString() + " " + Thread.currentThread().getName() + " " + log + System.lineSeparator());
    }

}