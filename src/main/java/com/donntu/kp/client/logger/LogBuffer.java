package com.donntu.kp.client.logger;

import java.util.ArrayList;
import java.util.List;

public class LogBuffer {
    private List<String> logs = new ArrayList<>();

    public List<String> getLogs() {
        return logs;
    }

    public void addLog(String log){
        if(log != null && !log.equals("")) {
            logs.add(log);
        }
    }

}
