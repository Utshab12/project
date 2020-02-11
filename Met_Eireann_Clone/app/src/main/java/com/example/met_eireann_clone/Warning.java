package com.example.met_eireann_clone;


//Model class for Warning Item


//NAME
//STUDENT NUMBER

public class Warning {
    public String areaS, levelS, typeS;

    public Warning(String areaS, String levelS, String typeS) {
        this.areaS = areaS;
        this.levelS = levelS;
        this.typeS = typeS;
    }

    public String getAreaS() {
        return areaS;
    }

    public void setAreaS(String areaS) {
        this.areaS = areaS;
    }

    public String getLevelS() {
        return levelS;
    }

    public void setLevelS(String levelS) {
        this.levelS = levelS;
    }

    public String getTypeS() {
        return typeS;
    }

    public void setTypeS(String typeS) {
        this.typeS = typeS;
    }

    @Override
    public String toString() {
        return "Warning{" +
                "areaS='" + areaS + '\'' +
                ", levelS='" + levelS + '\'' +
                ", typeS='" + typeS + '\'' +
                '}';
    }
}
