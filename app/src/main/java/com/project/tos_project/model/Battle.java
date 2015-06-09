package com.project.tos_project.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LAI on 2015/6/9.
 */
public class Battle {
    private int bossHP;
    private String bossColor;
    private int bossDefence;
    private int numOfCombo;
    private List<Integer> numOfRed;
    private List<Integer> numOfBlue;
    private List<Integer> numOfGreen;
    private List<Integer> numOfYellow;
    private List<Integer> numOfPurple;
    private int numOfEnchantedRed;
    private int numOfEnchantedBlue;
    private int numOfEnchantedGreen;
    private int numOfEnchantedYellow;
    private int numOfEnchantedPurple;

    //Skills
    private double eachComboFactor;
    private double colorSuppressionFactor;

    private Boolean enablePinkPossessRed;
    private double pinkPossessRedFactor;
    private Boolean enablePinkPossessBlue;
    private double pinkPossessBlueFactor;
    private Boolean enablePinkPossessGreen;
    private double pinkPossessGreenFactor;
    private Boolean enablePinkPossessYellow;
    private double pinkPossessYellowFactor;
    private Boolean enablePinkPossessPurple;
    private double pinkPossessPurpleFactor;

    private Boolean enable2Red;
    private Boolean enable2Green;
    private Boolean enable2Pink;


    public Battle() {
        eachComboFactor = 0.25;
        colorSuppressionFactor = 1.5;
        numOfRed = new ArrayList<>();
        numOfBlue = new ArrayList<>();
        numOfGreen = new ArrayList<>();
        numOfYellow = new ArrayList<>();
        numOfPurple = new ArrayList<>();
    }

    public int getBossHP() {
        return bossHP;
    }

    public void setBossHP(int bossHP) {
        this.bossHP = bossHP;
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

    public double getColorSuppressionFactor() {
        return colorSuppressionFactor;
    }

    public void setColorSuppressionFactor(double colorSuppressionFactor) {
        this.colorSuppressionFactor = colorSuppressionFactor;
    }

    public Boolean getEnablePinkPossessRed() {
        return enablePinkPossessRed;
    }

    public void setEnablePinkPossessRed(Boolean enablePinkPossessRed) {
        this.enablePinkPossessRed = enablePinkPossessRed;
    }

    public double getPinkPossessRedFactor() {
        return pinkPossessRedFactor;
    }

    public void setPinkPossessRedFactor(double pinkPossessRedFactor) {
        this.pinkPossessRedFactor = pinkPossessRedFactor;
    }

    public Boolean getEnablePinkPossessBlue() {
        return enablePinkPossessBlue;
    }

    public void setEnablePinkPossessBlue(Boolean enablePinkPossessBlue) {
        this.enablePinkPossessBlue = enablePinkPossessBlue;
    }

    public double getPinkPossessBlueFactor() {
        return pinkPossessBlueFactor;
    }

    public void setPinkPossessBlueFactor(double pinkPossessBlueFactor) {
        this.pinkPossessBlueFactor = pinkPossessBlueFactor;
    }

    public Boolean getEnablePinkPossessGreen() {
        return enablePinkPossessGreen;
    }

    public void setEnablePinkPossessGreen(Boolean enablePinkPossessGreen) {
        this.enablePinkPossessGreen = enablePinkPossessGreen;
    }

    public double getPinkPossessGreenFactor() {
        return pinkPossessGreenFactor;
    }

    public void setPinkPossessGreenFactor(double pinkPossessGreenFactor) {
        this.pinkPossessGreenFactor = pinkPossessGreenFactor;
    }

    public Boolean getEnablePinkPossessYellow() {
        return enablePinkPossessYellow;
    }

    public void setEnablePinkPossessYellow(Boolean enablePinkPossessYellow) {
        this.enablePinkPossessYellow = enablePinkPossessYellow;
    }

    public double getPinkPossessYellowFactor() {
        return pinkPossessYellowFactor;
    }

    public void setPinkPossessYellowFactor(double pinkPossessYellowFactor) {
        this.pinkPossessYellowFactor = pinkPossessYellowFactor;
    }

    public Boolean getEnablePinkPossessPurple() {
        return enablePinkPossessPurple;
    }

    public void setEnablePinkPossessPurple(Boolean enablePinkPossessPurple) {
        this.enablePinkPossessPurple = enablePinkPossessPurple;
    }

    public double getPinkPossessPurpleFactor() {
        return pinkPossessPurpleFactor;
    }

    public void setPinkPossessPurpleFactor(double pinkPossessPurpleFactor) {
        this.pinkPossessPurpleFactor = pinkPossessPurpleFactor;
    }

    public Boolean getEnable2Red() {
        return enable2Red;
    }

    public void setEnable2Red(Boolean enable2Red) {
        this.enable2Red = enable2Red;
    }

    public Boolean getEnable2Green() {
        return enable2Green;
    }

    public void setEnable2Green(Boolean enable2Green) {
        this.enable2Green = enable2Green;
    }

    public Boolean getEnable2Pink() {
        return enable2Pink;
    }

    public void setEnable2Pink(Boolean enable2Pink) {
        this.enable2Pink = enable2Pink;
    }
}
