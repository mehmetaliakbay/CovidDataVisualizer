package sample;

public class LineData {
    private Integer totalDeath;
    private String date;

    public LineData(Integer totalDeath, String date) {
        this.totalDeath = totalDeath;
        this.date = date;
    }

    public Integer getTotalDeath() {
        return totalDeath;
    }

    public void setTotalDeath(Integer totalDeath) {
        this.totalDeath = totalDeath;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        date = date;
    }

    @Override
    public String toString() {
        return "LineData{" +
                "totalDeath=" + totalDeath +
                ", date='" + date + '\'' +
                '}';
    }
}
