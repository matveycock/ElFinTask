package ru.matveycock.ElFinTask.model;

import lombok.Data;

import java.util.Map;

@Data
public class Result {

    private boolean successful;
    private Map<String, String> details;

    public Result(boolean successful, Map<String, String> details) {
        this.successful = successful;
        this.details = details;
    }
}
