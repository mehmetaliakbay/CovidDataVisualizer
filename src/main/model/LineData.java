package main.model;

public class LineData {
    private Integer totalDeath;
    private String time;

    public LineData(Integer totalDeath, String time) {
        this.totalDeath = totalDeath;
        this.time = time;
    }

    public Integer getTotalDeath() {
        return totalDeath;
    }

    public void setTotalDeath(Integer totalDeath) {
        this.totalDeath = totalDeath;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
