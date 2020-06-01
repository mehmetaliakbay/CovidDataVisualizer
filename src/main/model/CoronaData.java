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



    /**
     *  Constructer for parse data and create lineChart
     */
    public CoronaData(String time, Integer day, Integer month, Integer year,
                      Integer newCase, Integer newDeath, String country,
                      Integer population, String continent,Integer totalDeath, Integer totalCases) {
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
        this.totalCases = totalCases;
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


    public Integer getTotalCases() {
        return totalCases;
    }


    public Integer getTotalDeath() {
        return totalDeath;
    }

    public String getTime() {
        return time;
    }



    public Integer getNewCase() {
        return newCase;
    }


    public Integer getNewDeath() {
        return newDeath;
    }


    public String getCountry() {
        return country;
    }


    public Integer getPopulation() {
        return population;
    }

    public Double getMortality() {
        return mortality;
    }

    public Double getAttackRate() {
        return attackRate;
    }

}
