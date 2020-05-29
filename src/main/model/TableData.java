package main.model;

public class TableData {
    private Integer newCase;
    private Integer newDeath;
    private String country;
    private Integer population;
    private Integer totalCases;
    private Integer totalDeath;
    private Double mortality;
    private Double attackRate;





    public TableData(Integer newCase, Integer newDeath, String country,
                     Integer population, Integer totalCases,
                     Integer totalDeath, Double mortality, Double attackRate) {
        this.newCase = newCase;
        this.newDeath = newDeath;
        this.country = country;
        this.population = population;
        this.totalCases = totalCases;
        this.totalDeath = totalDeath;
        this.mortality = mortality;
        this.attackRate = attackRate;
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
    @Override
    public String toString() {
        return "TableData{" +
                "newCase=" + newCase +
                ", newDeath=" + newDeath +
                ", country='" + country + '\'' +
                ", population=" + population +
                ", totalCases=" + totalCases +
                ", totalDeath=" + totalDeath +
                ", mortality=" + mortality +
                ", attackRate=" + attackRate +
                '}';
    }

}
