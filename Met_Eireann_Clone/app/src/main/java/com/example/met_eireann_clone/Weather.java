package com.example.met_eireann_clone;


//Model class for Weather Item

//NAME
//STUDENT NUMBER
public class Weather {

    public String dayName;
    public int centigradeTemp;

    public Weather(String dayName, int centigradeTemp) {
        this.dayName = dayName;
        this.centigradeTemp = centigradeTemp;
    }

    public String getDayName() {
        return dayName;
    }

    public void setDayName(String dayName) {
        this.dayName = dayName;
    }

    public int getCentigradeTemp() {
        return centigradeTemp;
    }

    public void setCentigradeTemp(int centigradeTemp) {
        this.centigradeTemp = centigradeTemp;
    }
}
