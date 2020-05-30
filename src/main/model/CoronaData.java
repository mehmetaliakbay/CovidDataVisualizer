package main.model;


public class CoronaData {
    private String time;
    private Integer day;
    private Integer month;
    private Integer year;
    private Integer newCase;
    private Integer newDeath;
    private String country;
    private Integer population;
    private String continent;
    private Integer totalCases;
    private Integer totalDeath;
    private Double mortality;
    private Double attackRate;

    public CoronaData(String time, Integer day, Integer month, Integer year, Integer newCase,
                      Integer newDeath, String country, Integer population, String continent,
                      Integer totalCases, Integer totalDeath, Double mortality, Double attackRate) {
        this.time = time;
        this.day = day;
        this.month = month;
        this.year = year;
        this.newCase = newCase;
        this.newDeath = newDeath;
        this.country = country;
        this.population = population;
        this.continent = continent;
        this.totalCases = totalCases;
        this.totalDeath = totalDeath;
        this.mortality = mortality;
        this.attackRate = attackRate;
    }

    public CoronaData(String time, Integer day, Integer month, Integer year,
                      Integer newCase, Integer newDeath, String country,
                      Integer population, String continent,Integer totalDeath) {
        this.time = time;
        this.day = day;
        this.month = month;
        this.year = year;
        this.newCase = newCase;
        this.newDeath = newDeath;
        this.country = country;
        this.population = population;
        this.continent = continent;
        this.totalDeath = totalDeath;
    }

    /**
     *Constructer for table view data
     */
    public CoronaData(Integer newCase, Integer newDeath, String country,
                      Integer population, Integer totalCases, Integer totalDeath,
                      Double mortality, Double attackRate) {
        this.newCase = newCase;
        this.newDeath = newDeath;
        this.country = country;
        this.population = population;
        this.totalCases = totalCases;
        this.totalDeath = totalDeath;
        this.mortality = mortality;
        this.attackRate = attackRate;
    }

    /**
     * this constructer created for LineChart data
     */
    public CoronaData(String time, Integer totalCases, Integer totalDeath) {
        this.time = time;
        this.totalCases = totalCases;
        this.totalDeath = totalDeath;
    }

    public Integer getTotalCases() {
        return totalCases;
    }

    public void setTotalCases(Integer totalCases) {
        this.totalCases = totalCases;
    }

    public Integer getTotalDeath() {
        return totalDeath;
    }

    public void setTotalDeath(Integer totalDeath) {
        this.totalDeath = totalDeath;
    }

    public Double getMortality() {
        return mortality;
    }

    public void setMortality(Double mortality) {
        this.mortality = mortality;
    }

    public Double getAttackRate() {
        return attackRate;
    }

    public void setAttackRate(Double attackRate) {
        this.attackRate = attackRate;
    }


    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getNewCase() {
        return newCase;
    }

    public void setNewCase(Integer newCase) {
        this.newCase = newCase;
    }

    public Integer getNewDeath() {
        return newDeath;
    }

    public void setNewDeath(Integer newDeath) {
        this.newDeath = newDeath;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }
}
