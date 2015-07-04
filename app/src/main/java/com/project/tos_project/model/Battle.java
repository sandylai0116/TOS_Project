package com.project.tos_project.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LAI on 2015/6/9.
 */
public class Battle implements Parcelable {
    private String bossColor;
    private int bossDefence;
    private int maxHP;
    private int currentHP;
    private int numOfCombo;
    private List<Integer> numOfRed;
    private List<Integer> numOfBlue;
    private List<Integer> numOfGreen;
    private List<Integer> numOfYellow;
    private List<Integer> numOfPurple;
    private List<Integer> numOfPink;
    private int numOfEnchantedRed;
    private int numOfEnchantedBlue;
    private int numOfEnchantedGreen;
    private int numOfEnchantedYellow;
    private int numOfEnchantedPurple;
    private int numOfEnchantedPink;

    //stone array
    private int stoneArray[][];

    //leader skills
    private double eachComboFactor;

    private boolean enableSuppression;
    private double specialSuppressionFactor;
    private double blueSuppressRedFactor;
    private double redSuppressGreenFactor;
    private double greenSuppressBlueFactor;
    private double yellowSuppressPurpleFactor;
    private double purpleSuppressYellowFactor;
    private double blueSuppressPurpleFactor;
    private double redSuppressRedFactor;
    private double greenSuppressYellowFactor;
    private double yellowSuppressRedFactor;
    private double purpleSuppressGreenFactor;

    private boolean enablePinkPossessBlue;
    private boolean enablePinkPossessRed;
    private boolean enablePinkPossessGreen;
    private boolean enablePinkPossessYellow;
    private boolean enablePinkPossessPurple;
    private boolean enableYellowPossessPurple;
    private boolean enablePurplePossessYellow;
    private boolean enableRedPossessBlue;
    private boolean enableGreenPossessBlue;

    private List<Integer> blueForPossession;
    private List<Integer> redForPossession;
    private List<Integer> greenForPossession;
    private List<Integer> yellowForPossession;
    private List<Integer> purpleForPossession;

    private List<Double> blueForPossessFactor;
    private List<Double> redForPossessFactor;
    private List<Double> greenForPossessFactor;
    private List<Double> yellowForPossessFactor;
    private List<Double> purpleForPossessFactor;

    private boolean enable2Red;
    private boolean enable2Green;
    private boolean enable2Pink;

    public Battle() {
        stoneArray = new int[5][6];
        eachComboFactor = 0.25;
        enableSuppression = true;
        specialSuppressionFactor = 1.0;
        blueSuppressRedFactor = 1.5;
        redSuppressGreenFactor = 1.5;
        greenSuppressBlueFactor = 1.5;
        yellowSuppressPurpleFactor = 1.5;
        purpleSuppressYellowFactor = 1.5;
        blueSuppressPurpleFactor = 1.5;
        redSuppressRedFactor = 1.5;
        greenSuppressYellowFactor = 1.5;
        yellowSuppressRedFactor = 1.5;
        purpleSuppressGreenFactor = 1.5;
        numOfRed = new ArrayList<>();
        numOfBlue = new ArrayList<>();
        numOfGreen = new ArrayList<>();
        numOfYellow = new ArrayList<>();
        numOfPurple = new ArrayList<>();
        blueForPossession = new ArrayList<>();
        redForPossession = new ArrayList<>();
        greenForPossession = new ArrayList<>();
        yellowForPossession = new ArrayList<>();
        purpleForPossession = new ArrayList<>();
        blueForPossessFactor = new ArrayList<>();
        redForPossessFactor = new ArrayList<>();
        greenForPossessFactor = new ArrayList<>();
        yellowForPossessFactor = new ArrayList<>();
        purpleForPossessFactor = new ArrayList<>();
        bossColor = "";
    }

    public Battle (Parcel parcel) {
        this.eachComboFactor = parcel.readDouble();
        this.specialSuppressionFactor = parcel.readDouble();
        this.blueSuppressRedFactor = parcel.readDouble();
        this.redSuppressGreenFactor = parcel.readDouble();
        this.greenSuppressBlueFactor = parcel.readDouble();
        this.yellowSuppressPurpleFactor = parcel.readDouble();
        this.purpleSuppressYellowFactor = parcel.readDouble();
        this.blueSuppressPurpleFactor = parcel.readDouble();
        this.redSuppressRedFactor = parcel.readDouble();
        this.greenSuppressYellowFactor = parcel.readDouble();
        this.yellowSuppressRedFactor = parcel.readDouble();
        this.purpleSuppressGreenFactor = parcel.readDouble();
        this.numOfRed = parcel.readArrayList(null);
        this.numOfBlue = parcel.readArrayList(null);
        this.numOfGreen = parcel.readArrayList(null);
        this.numOfYellow = parcel.readArrayList(null);
        this.numOfPurple = parcel.readArrayList(null);
        this.bossColor = parcel.readString();
    }

    public static final Parcelable.Creator<Battle> CREATOR = new Creator<Battle>() {
        public Battle createFromParcel(Parcel source) {
            return new Battle(source);
        }
        public Battle[] newArray(int size) {
            return new Battle[size];
        }
    };

    public int describeContents() {
        return 0;
    }
    public void writeToParcel(Parcel parcel, int flags) {
        parcel.writeDouble(eachComboFactor);
        parcel.writeDouble(specialSuppressionFactor);
        parcel.writeDouble(blueSuppressRedFactor);
        parcel.writeDouble(redSuppressGreenFactor);
        parcel.writeDouble(greenSuppressBlueFactor);
        parcel.writeDouble(yellowSuppressPurpleFactor);
        parcel.writeDouble(purpleSuppressYellowFactor);
        parcel.writeDouble(blueSuppressPurpleFactor);
        parcel.writeDouble(redSuppressRedFactor);
        parcel.writeDouble(greenSuppressYellowFactor);
        parcel.writeDouble(yellowSuppressRedFactor);
        parcel.writeDouble(purpleSuppressGreenFactor);
        parcel.writeList(numOfRed);
        parcel.writeList(numOfBlue);
        parcel.writeList(numOfGreen);
        parcel.writeList(numOfYellow);
        parcel.writeList(numOfPurple);
        parcel.writeString(bossColor);
    }

    public int getCurrentHP() {
        return currentHP;
    }

    public void setCurrentHP(int currentHP) {
        this.currentHP = currentHP;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public List<Integer> getNumOfPink() {
        return numOfPink;
    }

    public void setNumOfPink(List<Integer> numOfPink) {
        this.numOfPink = numOfPink;
    }

    public double getSpecialSuppressionFactor() {
        return specialSuppressionFactor;
    }

    public void setSpecialSuppressionFactor(double specialSuppressionFactor) {
        this.specialSuppressionFactor = specialSuppressionFactor;
    }

    public int getNumOfEnchantedPink() {
        return numOfEnchantedPink;
    }

    public void setNumOfEnchantedPink(int numOfEnchantedPink) {
        this.numOfEnchantedPink = numOfEnchantedPink;
    }

    public void setMaxHP(int maxHP) {
        this.maxHP = maxHP;
    }

    public String getBossColor() {
        return bossColor;
    }

    public void setBossColor(String bossColor) {
        this.bossColor = bossColor;
    }

    public int getBossDefence() {
        return bossDefence;
    }

    public void setBossDefence(int bossDefence) {
        this.bossDefence = bossDefence;
    }

    public int getNumOfCombo() {
        return numOfCombo;
    }

    public void setNumOfCombo(int numOfCombo) {
        this.numOfCombo = numOfCombo;
    }

    public List<Integer> getNumOfRed() {
        return numOfRed;
    }

    public void setNumOfRed(List<Integer> numOfRed) {
        this.numOfRed = numOfRed;
    }

    public List<Integer> getNumOfBlue() {
        return numOfBlue;
    }

    public void setNumOfBlue(List<Integer> numOfBlue) {
        this.numOfBlue = numOfBlue;
    }

    public List<Integer> getNumOfGreen() {
        return numOfGreen;
    }

    public void setNumOfGreen(List<Integer> numOfGreen) {
        this.numOfGreen = numOfGreen;
    }

    public List<Integer> getNumOfYellow() {
        return numOfYellow;
    }

    public void setNumOfYellow(List<Integer> numOfYellow) {
        this.numOfYellow = numOfYellow;
    }

    public List<Integer> getNumOfPurple() {
        return numOfPurple;
    }

    public void setNumOfPurple(List<Integer> numOfPurple) {
        this.numOfPurple = numOfPurple;
    }

    public int getNumOfEnchantedRed() {
        return numOfEnchantedRed;
    }

    public void setNumOfEnchantedRed(int numOfEnchantedRed) {
        this.numOfEnchantedRed = numOfEnchantedRed;
    }

    public int getNumOfEnchantedBlue() {
        return numOfEnchantedBlue;
    }

    public void setNumOfEnchantedBlue(int numOfEnchantedBlue) {
        this.numOfEnchantedBlue = numOfEnchantedBlue;
    }

    public int getNumOfEnchantedGreen() {
        return numOfEnchantedGreen;
    }

    public void setNumOfEnchantedGreen(int numOfEnchantedGreen) {
        this.numOfEnchantedGreen = numOfEnchantedGreen;
    }

    public int getNumOfEnchantedYellow() {
        return numOfEnchantedYellow;
    }

    public void setNumOfEnchantedYellow(int numOfEnchantedYellow) {
        this.numOfEnchantedYellow = numOfEnchantedYellow;
    }

    public int getNumOfEnchantedPurple() {
        return numOfEnchantedPurple;
    }

    public void setNumOfEnchantedPurple(int numOfEnchantedPurple) {
        this.numOfEnchantedPurple = numOfEnchantedPurple;
    }

    public double getEachComboFactor() {
        return eachComboFactor;
    }

    public void setEachComboFactor(double eachComboFactor) {
        this.eachComboFactor = eachComboFactor;
    }



    public double getBlueSuppressRedFactor() {
        return blueSuppressRedFactor;
    }

    public void setBlueSuppressRedFactor(double blueSuppressRedFactor) {
        this.blueSuppressRedFactor = blueSuppressRedFactor;
    }

    public double getRedSuppressGreenFactor() {
        return redSuppressGreenFactor;
    }

    public void setRedSuppressGreenFactor(double redSuppressGreenFactor) {
        this.redSuppressGreenFactor = redSuppressGreenFactor;
    }

    public double getGreenSuppressBlueFactor() {
        return greenSuppressBlueFactor;
    }

    public void setGreenSuppressBlueFactor(double greenSuppressBlueFactor) {
        this.greenSuppressBlueFactor = greenSuppressBlueFactor;
    }

    public double getYellowSuppressPurpleFactor() {
        return yellowSuppressPurpleFactor;
    }

    public void setYellowSuppressPurpleFactor(double yellowSuppressPurpleFactor) {
        this.yellowSuppressPurpleFactor = yellowSuppressPurpleFactor;
    }

    public double getPurpleSuppressYellowFactor() {
        return purpleSuppressYellowFactor;
    }

    public void setPurpleSuppressYellowFactor(double purpleSuppressYellowFactor) {
        this.purpleSuppressYellowFactor = purpleSuppressYellowFactor;
    }

    public double getBlueSuppressPurpleFactor() {
        return blueSuppressPurpleFactor;
    }

    public void setBlueSuppressPurpleFactor(double blueSuppressPurpleFactor) {
        this.blueSuppressPurpleFactor = blueSuppressPurpleFactor;
    }

    public double getRedSuppressRedFactor() {
        return redSuppressRedFactor;
    }

    public void setRedSuppressRedFactor(double redSuppressRedFactor) {
        this.redSuppressRedFactor = redSuppressRedFactor;
    }

    public double getGreenSuppressYellowFactor() {
        return greenSuppressYellowFactor;
    }

    public void setGreenSuppressYellowFactor(double greenSuppressYellowFactor) {
        this.greenSuppressYellowFactor = greenSuppressYellowFactor;
    }

    public double getYellowSuppressRedFactor() {
        return yellowSuppressRedFactor;
    }

    public void setYellowSuppressRedFactor(double yellowSuppressRedFactor) {
        this.yellowSuppressRedFactor = yellowSuppressRedFactor;
    }

    public double getPurpleSuppressGreenFactor() {
        return purpleSuppressGreenFactor;
    }

    public void setPurpleSuppressGreenFactor(double purpleSuppressGreenFactor) {
        this.purpleSuppressGreenFactor = purpleSuppressGreenFactor;
    }

    public boolean getEnablePinkPossessRed() {
        return enablePinkPossessRed;
    }

    public void setEnablePinkPossessRed(boolean enablePinkPossessRed) {
        this.enablePinkPossessRed = enablePinkPossessRed;
    }

    public boolean getEnablePinkPossessBlue() {
        return enablePinkPossessBlue;
    }

    public void setEnablePinkPossessBlue(boolean enablePinkPossessBlue) {
        this.enablePinkPossessBlue = enablePinkPossessBlue;
    }

    public boolean getEnablePinkPossessGreen() {
        return enablePinkPossessGreen;
    }

    public void setEnablePinkPossessGreen(boolean enablePinkPossessGreen) {
        this.enablePinkPossessGreen = enablePinkPossessGreen;
    }

    public boolean getEnablePinkPossessYellow() {
        return enablePinkPossessYellow;
    }

    public void setEnablePinkPossessYellow(boolean enablePinkPossessYellow) {
        this.enablePinkPossessYellow = enablePinkPossessYellow;
    }

    public boolean getEnablePinkPossessPurple() {
        return enablePinkPossessPurple;
    }

    public void setEnablePinkPossessPurple(boolean enablePinkPossessPurple) {
        this.enablePinkPossessPurple = enablePinkPossessPurple;
    }

    public boolean getEnable2Red() {
        return enable2Red;
    }

    public void setEnable2Red(boolean enable2Red) {
        this.enable2Red = enable2Red;
    }

    public boolean getEnable2Green() {
        return enable2Green;
    }

    public void setEnable2Green(boolean enable2Green) {
        this.enable2Green = enable2Green;
    }

    public boolean getEnable2Pink() {
        return enable2Pink;
    }

    public void setEnable2Pink(boolean enable2Pink) {
        this.enable2Pink = enable2Pink;
    }

    public boolean isEnablePinkPossessRed() {
        return enablePinkPossessRed;
    }

    public boolean isEnablePinkPossessBlue() {
        return enablePinkPossessBlue;
    }

    public boolean isEnablePinkPossessGreen() {
        return enablePinkPossessGreen;
    }

    public boolean isEnablePinkPossessYellow() {
        return enablePinkPossessYellow;
    }

    public boolean isEnablePinkPossessPurple() {
        return enablePinkPossessPurple;
    }

    public boolean isEnableYellowPossessPurple() {
        return enableYellowPossessPurple;
    }

    public void setEnableYellowPossessPurple(boolean enableYellowPossessPurple) {
        this.enableYellowPossessPurple = enableYellowPossessPurple;
    }

    public boolean isEnablePurplePossessYellow() {
        return enablePurplePossessYellow;
    }

    public void setEnablePurplePossessYellow(boolean enablePurplePossessYellow) {
        this.enablePurplePossessYellow = enablePurplePossessYellow;
    }

    public boolean isEnable2Red() {
        return enable2Red;
    }

    public boolean isEnable2Green() {
        return enable2Green;
    }

    public boolean isEnable2Pink() {
        return enable2Pink;
    }

    public List<Integer> getBlueForPossession() {
        return blueForPossession;
    }

    public void setBlueForPossession(List<Integer> blueForPossession) {
        this.blueForPossession = blueForPossession;
    }

    public List<Integer> getRedForPossession() {
        return redForPossession;
    }

    public void setRedForPossession(List<Integer> redForPossession) {
        this.redForPossession = redForPossession;
    }

    public List<Integer> getGreenForPossession() {
        return greenForPossession;
    }

    public void setGreenForPossession(List<Integer> greenForPossession) {
        this.greenForPossession = greenForPossession;
    }

    public List<Integer> getYellowForPossession() {
        return yellowForPossession;
    }

    public void setYellowForPossession(List<Integer> yellowForPossession) {
        this.yellowForPossession = yellowForPossession;
    }

    public List<Integer> getPurpleForPossession() {
        return purpleForPossession;
    }

    public void setPurpleForPossession(List<Integer> purpleForPossession) {
        this.purpleForPossession = purpleForPossession;
    }

    public List<Double> getBlueForPossessFactor() {
        return blueForPossessFactor;
    }

    public void setBlueForPossessFactor(List<Double> blueForPossessFactor) {
        this.blueForPossessFactor = blueForPossessFactor;
    }

    public List<Double> getRedForPossessFactor() {
        return redForPossessFactor;
    }

    public void setRedForPossessFactor(List<Double> redForPossessFactor) {
        this.redForPossessFactor = redForPossessFactor;
    }

    public List<Double> getGreenForPossessFactor() {
        return greenForPossessFactor;
    }

    public void setGreenForPossessFactor(List<Double> greenForPossessFactor) {
        this.greenForPossessFactor = greenForPossessFactor;
    }

    public List<Double> getYellowForPossessFactor() {
        return yellowForPossessFactor;
    }

    public void setYellowForPossessFactor(List<Double> yellowForPossessFactor) {
        this.yellowForPossessFactor = yellowForPossessFactor;
    }

    public List<Double> getPurpleForPossessFactor() {
        return purpleForPossessFactor;
    }

    public void setPurpleForPossessFactor(List<Double> purpleForPossessFactor) {
        this.purpleForPossessFactor = purpleForPossessFactor;
    }

    public boolean isEnableSuppression() {
        return enableSuppression;
    }

    public void setEnableSuppression(boolean enableSuppression) {
        this.enableSuppression = enableSuppression;
    }

    public boolean isEnableRedPossessBlue() {
        return enableRedPossessBlue;
    }

    public void setEnableRedPossessBlue(boolean enableRedPossessBlue) {
        this.enableRedPossessBlue = enableRedPossessBlue;
    }

    public boolean isEnableGreenPossessBlue() {
        return enableGreenPossessBlue;
    }

    public void setEnableGreenPossessBlue(boolean enableGreenPossessBlue) {
        this.enableGreenPossessBlue = enableGreenPossessBlue;
    }

    public int[][] getStoneArray() {
        return stoneArray;
    }

    public void setStoneArray(int[][] stoneArray) {
        this.stoneArray = stoneArray;
    }
}
