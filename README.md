# JavaFX Corona Pandemic Data Visualization

This project automatically get the daily data on the coronavirus pandemic
(COVID-19) provided by the European Centre for Disease Prevention and Control
(ECDC). I use EU Open Data Portal COVID-19 Coronavirus dataset
(https://opendata.ecdc.europa.eu/covid19/casedistribution/xml/) which is
updated daily.


# Visualization of the Data

After extracting the data from the specified XML file, the program visualizes
it by using tables and graphs. This program contains the following tables
and graphs.

## Reported cases and deaths by country table
This table shows the number of cases and deaths, mortality rate, and attack rate per country.
The table contains the following columns: Country, Total Cases, New Cases,
Total Deaths, New Deaths, Population, Mortality (total deaths/total cases), attack
rate (total cases/population). While the New Cases and New Deaths columns show
the cases and deaths for that day, it calculates the numbers that will be
shown in the other columns appropriately. The user can sort data by
all columns.


## The cumulative number of cases and deaths by country graphics

There are two graphs that show the total cases and deaths by countries over
time. The graphs a line chart in which each line with a different color,
represent a country. There is a also a listview next to graphs,
which list the names of countries. The user can select/deselect
multiple countries in the listview to be displayed on the graphs. The graph can updated when the user changed their choices. 


## Some Images from project

<img src="https://github.com/mhmtaliakbay/CovidDataVisualizer/blob/master/doc/screenshot1.PNG" style="height:100px;width:100px">
<img src="https://github.com/mhmtaliakbay/CovidDataVisualizer/blob/master/doc/screenshot2.PNG" style="height:100px;width:100px">
