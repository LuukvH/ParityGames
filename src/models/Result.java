package models;

import java.util.List;
import java.util.Set;

/**
 * Created by laj on 29-3-2016.
 */
public class Result {

    private String game;
    private String strategy;

    public int getItterations() {
        return itterations;
    }

    public void setItterations(int itterations) {
        this.itterations = itterations;
    }

    private int itterations;

    public void setDuration(long duration) {
        this.duration = duration;
    }

    private long duration;
    public List<Integer> even;
    public List<Integer> odd;

    public Result(String strategy, int itterations, long duration) {
        this.strategy = strategy;
        this.itterations = itterations;
        this.duration = duration;
    }

    public Long getDuration() {
        return duration;
    }

    public void setGame (String value) {
        game = value;
    }

    public String toJSON() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("{");
        stringBuilder.append(String.format("\"game\":\"%s\",\"strategy\":\"%s\",\"iterations\":%d,\"duration\":%d,\"odd\":%s,\"even\":%s", game, strategy, itterations, duration, odd.toString(), even.toString()));
        stringBuilder.append("}");
        return stringBuilder.toString();
    }
}
